import java.util.*;
import java.text.SimpleDateFormat;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws Exception {
        
        // 약관종류/유효기간 관리할 HashMap
        Map<String, Integer> map = new HashMap<>();
        // " " 기준으로 담을 임시 배열
        String [] temp = new String [2];                            
        
        for (int i = 0; i < terms.length; i ++) 
        {
            // terms 배열의 " " 기준으로 temp 배열 생성
            temp = terms[i].split(" ");
            // temp 배열을 이용해서 map 추가
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        // today 날짜 변환
        String today2 = today.replace(".", "");
        
        int year = Integer.parseInt(today2.substring(0, 4));
        int month = Integer.parseInt(today2.substring(4, 6));
        int day = Integer.parseInt(today2.substring(6, 8));
        
        // today 일수변환
        int days = (year * 12 * 28) + (month * 28) + day;
        
        // result용 ArrayList 생성
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        for (int j = 0; j < privacies.length; j ++)
        {
            temp = privacies[j].split(" ");
            
            // 수집일자 "." 기준으로 날짜 변환
            String [] pdate = temp[0].split("\\.");

            // 수집일자에 유효기간 계산하여 유효일자 구하기
            int pyear =  Integer.parseInt(pdate[0]);
            int pmonth =  Integer.parseInt(pdate[1]) + map.get(temp[1]);
            int pday =  Integer.parseInt(pdate[2]);
            
            // 유효일자 일수변환
            int pdays = (pyear * 12 * 28) + (pmonth * 28) + pday - 1;
            
            if (days > pdays) 
            {
                arrList.add(j + 1);
            }
        }
        
        // ArrayList -> Array 변환
        int [] result = new int [arrList.size()];

        int idx = 0;

        for (int num : arrList)
        {
          result[idx++] = num;
        }

        return result;
    }
   
}