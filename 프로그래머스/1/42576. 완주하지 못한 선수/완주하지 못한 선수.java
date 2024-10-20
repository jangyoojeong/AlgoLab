import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> hm = new HashMap<>();

        for (String 선수 : participant) {
            hm.put(선수, hm.getOrDefault(선수, 0) + 1);
        }

        for (String 선수 : completion) {
            hm.put(선수, hm.get(선수) - 1);
        }

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }

        return "";
    }
}