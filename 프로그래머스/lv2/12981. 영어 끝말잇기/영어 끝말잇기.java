import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> hs = new HashSet<>();
        
        for (int i = 0; i < words.length; i ++) {
            String str = words[i];
            
            if (i != 0) {
                Character chaEnd   = words[i - 1].charAt(words[i - 1].length() - 1);   
                Character chaStart = words[i].charAt(0);
                
                if (!chaEnd.equals(chaStart)) {
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                }
                else if (hs.contains(str)) {
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                }
                
            }

            hs.add(str);
        }

        return answer;
    }
}  