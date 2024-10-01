import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// Strfry
// https://www.acmicpc.net/problem/11328
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str1 = stringTokenizer.nextToken();
            String str2 = stringTokenizer.nextToken();

            if (canBeRearranged(str1, str2)) {
                stringBuilder.append("Possible").append("\n");
            } else {
                stringBuilder.append("Impossible").append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

    public static boolean canBeRearranged(String str1, String str2) {
        // str1을 랜덤재배열 했을 때 str2가 나올 수 있는지 없는지 판단
        // case 1 : 두 문자열의 길이가 다른 경우 나올 수 없음.
        // case 2 : 두 문자열의 문자 빈도를 체크하여 같은지 확인

        if (str1.length() != str2.length()) {
            return false;
        }

        // 알파벳 소문자 기준 빈도수를 기록할 배열 생성
        int[] charCnt = new int[26];

        // 첫 번째 문자열에서 빈도수 기록
        for (char c : str1.toCharArray()) {
            charCnt[c - 'a']++;
        }

        // 두 번째 문자열에서 빈도수 감소
        for (char c : str2.toCharArray()) {
            charCnt[c - 'a']--;
        }

        // 최종적으로 0이면 두 문자열은 일치함
        for (int cnt : charCnt) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}