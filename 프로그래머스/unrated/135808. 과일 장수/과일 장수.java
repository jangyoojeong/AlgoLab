import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int result = 0;
        
        // 만들 수 있는 사과 상자 개수
        int box = score.length / m;
        
        Integer[] sortArr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sortArr, Collections.reverseOrder());
        
        int cnt = 0;
        
        int[] boxArr = new int[m];
        
        for (int i = 0; i < sortArr.length; i ++) 
        {
            boxArr[cnt] = sortArr[i];
            cnt++;
            
            if (cnt >= m) 
            {
                Arrays.sort(boxArr);
                
                result += boxArr[0] * m;
                
                cnt = 0;
            }
            
            
        }

        return result;
    }
}