import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // HashMap에 사이트 주소와 비밀번호 저장
        HashMap<String, String> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            hm.put(line[0], line[1]);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String 주소 = br.readLine();
            result.append(hm.get(주소)).append("\n");
        }

        System.out.println(result);
    }
}
