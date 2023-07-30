-- 코드를 입력하세요

SELECT TA.MEMBER_NAME, TB.REVIEW_TEXT, TO_CHAR(TB.REVIEW_DATE, 'YYYY-MM-DD')  AS REVIEW_DATE
  FROM MEMBER_PROFILE TA
     , REST_REVIEW TB
 WHERE TA.MEMBER_ID = TB.MEMBER_ID
 AND TB.MEMBER_ID = (
                    SELECT MEMBER_ID
                      FROM (
                            SELECT MEMBER_ID, ROW_NUMBER() OVER(ORDER BY COUNT(1) DESC) AS RNUM
                              FROM REST_REVIEW
                            GROUP BY MEMBER_ID

                           )
                          WHERE RNUM = 1
                     )
     ORDER BY TB.REVIEW_DATE,   TB.REVIEW_TEXT              
                     
                     
