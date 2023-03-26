import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String result = "";
        
        char[][] arr = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for (char[] t : arr) 
        {
            map.put(t[0], 0);
            map.put(t[1], 0);
        }
        
        for (int k = 0; k < survey.length; k ++) 
        {
            // 1 ~ 3
            if (choices[k] - 4 < 0) 
            {
                map.put(survey[k].charAt(0), map.get(survey[k].charAt(0)) + Math.abs(choices[k] - 4));
            }
            else
            {
                map.put(survey[k].charAt(1), map.get(survey[k].charAt(1)) + Math.abs(choices[k] - 4));
            }
        }
        
        for (char[] t : arr) 
        {
            result += map.get(t[0]) >= map.get(t[1]) ? t[0] : t[1];
        }
        
        return result;
    }
}
