import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine();
        System.out.println(getRequiredBracketCount(inputString));
    }

    public static int getRequiredBracketCount(String inputString) {
        int openBrackets = 0;  // 여는 괄호 '('의 수
        int unmatchedCloseBrackets = 0;       // 매칭되지 않은 닫는 괄호 ')'의 수

        for (char c : inputString.toCharArray()) {
            if (c == '(') {
                // 여는 괄호를 증가
                openBrackets++;
            } else {
                // 닫는 괄호일 경우 여는 괄호와 짝이 맞으면 감소
                if (openBrackets > 0) {
                    openBrackets--;
                } else {
                    // 매칭되지 않는 닫는 괄호
                    unmatchedCloseBrackets++;
                }
            }
        }

        return openBrackets + unmatchedCloseBrackets;
    }
}