import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long result = 0;
        int maxCount = 0;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            long key = entry.getKey();
            int count = entry.getValue();

            // 더 많이 가지고 있거나, 같은 횟수일 때 작은 값 선택
            if (count > maxCount || (count == maxCount && key < result)) {
                maxCount = count;
                result = key;
            }
        }

        System.out.println(result);
    }
}
