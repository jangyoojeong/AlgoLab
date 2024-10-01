import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 천재 수학자 성필
// https://www.acmicpc.net/problem/15815
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine();
        System.out.println(calculatePostfix(inputString));
    }

    public static int calculatePostfix (String inputString) {
        // 우리 세계의 식 -> 성필의 식 변환 방식
        // 1. 주어진 식을 연산자의 우선순위에 따라 괄호로 묶어준다.
        // a+b*c -> (a+(b*c))
        // 2. 괄호 안의 연산자를 괄호의 오른쪽으로 옮겨준다. (반복)
        // (a+(b*c)) -> a+bc*
        // a+bc* -> abc*+

        // 후위 표기식 : 연산자 앞에 두 숫자가 연산 대상이 되는 규칙을 가지고 있음!
        // 스택 자료구조를 이용해 뒤에서 부터 숫자를 꺼내어 연산하는 전략 사용
        // 숫자일 경우 스택에 넣고, 연산자일 경우 두 개의 숫자를 pop해서 연산 -> 결과를 다시 스택에 pop 하는 식으로 구현
        Stack<Integer> stack = new Stack<>();

        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            }
            else {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                switch (c) {
                    case '+' :
                        result = a + b;
                        break;
                    case '-' :
                        result = a - b;
                        break;
                    case '*' :
                        result = a * b;
                        break;
                    case '/' :
                        result = a / b;
                        break;
                }
                stack.push(result);
            }
        }
         return stack.pop();
    }
}