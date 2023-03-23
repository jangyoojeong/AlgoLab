import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        int num = 0;
        
        for (int move : moves) {
            for (int j = 0; j < board.length; j ++) {
                if (board[j][move - 1] != 0) {

                    if (basket.empty()) {
                        basket.push(board[j][move - 1]);
                    } 
                    else {
                        if (board[j][move - 1] == basket.peek()) {
                            basket.pop();
                            answer += 2;
                        } else {
                            basket.push(board[j][move - 1]);
                        }
                    }
                    
                    board[j][move - 1] = 0;
                    
                    break;
                }
                               
            }
            
        }        
        
        return answer;
    }
}