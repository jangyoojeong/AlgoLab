import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        int result = 0;
        
        // 만들 수 있는 사과 상자 개수
        int box = score.length / m;
        
        // score 정렬 (최대 이익 계산용)
        Integer[] sortArr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sortArr, Collections.reverseOrder());
        
        // 사과 개수 체크용
        int cnt = 0;
        
        // 사과 상자 배열
        int[] boxArr = new int[m];
        
        for (int i = 0; i < sortArr.length; i ++) 
        {
            boxArr[cnt] = sortArr[i];
            
            if (++cnt >= m) 
            {
                // 최저 사과 점수 구하기 위한 정렬
                Arrays.sort(boxArr);
                
                // 점수 누적 [최저 사과 점수 * 한 상자에 담긴 사과 개수]
                result += boxArr[0] * m;
                
                // 사과 개수 초기화
                cnt = 0;
            }
        }

        return result;
    }
}