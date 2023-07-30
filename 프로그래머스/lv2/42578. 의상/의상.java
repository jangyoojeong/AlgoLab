import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {

        // 옷 종류와 개수 구하기 (입지 않는 경우 포함)
        HashMap<String, Integer> map = new HashMap();

        for (String i[] : clothes) {
            map.put(i[1], map.getOrDefault(i[1], 1) + 1);
        }

        // 모든 조합 경우의 수 구하기
        int answer = 1;
        Iterator<Integer> it = map.values().iterator();

        while(it.hasNext()) {
            answer *= it.next().intValue();
        }

        // 아무것도 입지 않는경우 제외
        return answer - 1;
    }
}