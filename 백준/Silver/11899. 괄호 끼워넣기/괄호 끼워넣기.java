import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine();
        System.out.println(getRequiredBracketCount(inputString));
    }

    public static long getRequiredBracketCount(String inputString) {
        Stack<Character> stack = new Stack<>();
        int unmatchedCloseBrackets = 0;

        for (char bracket : inputString.toCharArray()) {
            if (stack.isEmpty() || bracket == '(') {
                stack.add(bracket);
            } else if (bracket == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                unmatchedCloseBrackets++;
            }
        }

        return stack.size() + unmatchedCloseBrackets;
    }
}