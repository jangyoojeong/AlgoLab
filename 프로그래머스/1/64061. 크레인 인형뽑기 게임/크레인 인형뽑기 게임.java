import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                int item = board[j][move - 1];
                if (board[j][move - 1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == item) {
                        stack.pop();
                        result += 2;
                    } else {
                        stack.push(item);
                    }

                    board[j][move - 1] = 0;
                    break;
                }
            }
        }

        return result;
    }
}