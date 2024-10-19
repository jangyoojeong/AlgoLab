import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        // 총총이를 먼저 추가
        set.add("ChongChong");

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String 사람1 = st.nextToken();
            String 사람2 = st.nextToken();

            // 총총이 등장 후부터 연결된 사람들 추가
            if (set.contains(사람1)) {
                set.add(사람2);
            } else if (set.contains(사람2)) {
                set.add(사람1);
            }
        }

        System.out.println(set.size());
    }
}
