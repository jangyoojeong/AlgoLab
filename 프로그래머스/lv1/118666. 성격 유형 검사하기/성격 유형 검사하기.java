import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String result = "";
        
        char[][] arr = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for (int i = 0; i < arr.length; i ++) 
        {
            for (int j = 0; j < arr[i].length; j ++) 
            {
                map.put(arr[i][j], 0);
            }
        }
        
        for (int k = 0; k < survey.length; k ++) 
        {
            
            // 1 ~ 3
            if (choices[k] - 4 < 0) 
            {
                int val = map.get(survey[k].charAt(0));
                
                map.put(survey[k].charAt(0), val + Math.abs(choices[k] - 4));
                
                // System.out.println("Key : " + survey[k].charAt(0) + ", Value : " + Math.abs(choices[k] - 4));
            }
            else if (choices[k] - 4 > 0) 
            {
                int val = map.get(survey[k].charAt(1));
                
                map.put(survey[k].charAt(1), val + Math.abs(choices[k] - 4));
                
                // System.out.println("Key : " + survey[k].charAt(1) + ", Value : " + Math.abs(choices[k] - 4));
            }
        }
        
        for (int i = 0; i < arr.length; i ++) 
        {
            if (map.get(arr[i][0]) >= (map.get(arr[i][1])))
            {
                result += arr[i][0];
            }
            else
            {
                result += arr[i][1];
            }
        }
        
        return result;
    }
}
