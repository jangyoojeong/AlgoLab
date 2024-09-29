import java.util.*;

class Solution {
public String solution(int n, int k, String[] cmd) {
        WorkNode workNode = new WorkNode(n, k);

        for(String command: cmd) {
            workNode.command(command);
        }

        return workNode.getNowStatusBoard();
    }

    public static class WorkNode {
        private int boardSize;
        private int cursor;
        private Stack<Integer> delHistory;

        public WorkNode(int n, int k) {
            boardSize = n;
            cursor = k;
            delHistory = new Stack<>();
        }

        public void command(String cmd) {
            String[] tokens = cmd.split(" ");
            switch (tokens[0]) {
                case "U":
                    int moveUp = Integer.parseInt(tokens[1]);
                    moveUp(moveUp);
                    break;
                case "D":
                    //아래로 n칸 이동
                    int moveDown = Integer.parseInt(tokens[1]);
                    moveDown(moveDown);
                    break;
                case "C":
                    //현재행 삭제 후 아래행 선책
                    delete();
                    break;
                case "Z":
                    //가장 최근 삭제된 행을 복구 단 현재 선택된 행은 변경 X
                    delRollback();
                    break;
            }
        }

        private void moveUp(int move) {
            //위로 n칸 이동
            if(cursor - move >= 0) {
                cursor = cursor - move;
            }
        }

        private void moveDown(int move) {
            //아래로 n칸 이동
            if(cursor + move < boardSize) {
                cursor = cursor + move;
            }
        }

        private void delete() {
            //현재행 삭제 후 아래행 선책
            delHistory.push(cursor);
            boardSize--;
            if(cursor == boardSize)
                cursor--;
        }

        private void delRollback() {
            //가장 최근 삭제된 행을 복구 단 현재 선택된 행은 변경 X
            if(delHistory.isEmpty()) return;

            int delPoint = delHistory.pop();
            boardSize++;
            if(delPoint <= cursor)
                cursor++;
        }

        public String getNowStatusBoard() {
            StringBuilder sb = new StringBuilder();
            sb.append("O".repeat(boardSize));
            while (!delHistory.isEmpty()) {
                sb.insert(delHistory.pop(), "X");
            }
            return sb.toString();
        }
    }
}