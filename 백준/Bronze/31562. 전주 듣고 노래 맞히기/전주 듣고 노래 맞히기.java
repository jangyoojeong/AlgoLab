import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        // N : 정환이 음을 아는 노래의 개수
        int N = Integer.parseInt(firstLine[0]);
        // M : 정환이 맞히기를 시도할 노래의 개수
        int M = Integer.parseInt(firstLine[1]);

        HashMap<String, String> 노래 = new HashMap<>();          // 음이름 - 노래 제목
        HashMap<String, Integer> 음이름빈도수 = new HashMap<>(); // 음이름 - 빈도수

        for (int i = 0; i < N; i ++) {
            String[] line = br.readLine().split(" ");
            String 노래제목 = line[1];
            String 음이름 = line[2] + line[3] + line[4];

            노래.put(음이름, 노래제목);
            음이름빈도수.put(음이름, 음이름빈도수.getOrDefault(음이름, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i ++) {
            String[] line = br.readLine().split(" ");
            String 맞출음이름 = line[0] + line[1] + line[2];

            int count = 음이름빈도수.getOrDefault(맞출음이름, 0);
            String result;

            // 음이름 빈도수에 따라 결과 설정
            if (count >= 2) result = "?";
            else if (count == 1) result = 노래.get(맞출음이름);
            else result = "!";

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
