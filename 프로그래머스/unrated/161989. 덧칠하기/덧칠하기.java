import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int [] arr = new int [n];
        List<Integer> sectionList = new ArrayList<>();
        
        for (int i : section) 
        {
            sectionList.add(i);
        }
        
        for (int i = 0; i < arr.length; i ++) 
        {
            if (sectionList.contains(i+1)) arr[i] = 0;
            else arr[i] = 1;
        }
        
        for (int k = 0; k < arr.length; k ++) 
        {
            if (arr[k] == 0) 
            {
                answer ++;
                for (int v = 0; v < m; v ++) 
                {
                    if (k + v < arr.length) 
                    {
                        arr[k + v] = 1;
                    }
                    
                }
            }
        }
        
        
        return answer;
    }
}