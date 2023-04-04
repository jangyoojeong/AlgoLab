import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        List<String> list = new ArrayList<>();
        
        for (String key : X.split("")) 
        {
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }
        
        for (String key : Y.split("")) 
        {
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }
        
        for (String key : map1.keySet()) 
        {
            if (!map2.containsKey(key)) continue;
            
            int length = Math.min(map1.get(key), map2.get(key));
            
            for(int i = 0; i < length; i++) {
                list.add(key);
            }
        }
        
        String result = list.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.joining());
        
        if(result.isEmpty()) return "-1";
        if(result.replaceAll("0", "").isEmpty()) return "0";
        return result;
    }
}