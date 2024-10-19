import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 배열 입력
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hs.add(Integer.parseInt(st.nextToken()));
        }

        // 두 번째 배열 입력
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            result.append(hs.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
        }

        System.out.println(result.toString());
    }
}
