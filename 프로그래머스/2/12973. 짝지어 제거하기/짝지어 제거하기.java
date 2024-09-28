import java.util.*;

class Solution {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack();

        // 입력 문자 순회
        for (int i = 0; i < s.length(); i ++) {

            char ch  = s.charAt(i);

            // 스택이 비어있지 않고, 직전 문자가 짝이 맞다면 제거
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
