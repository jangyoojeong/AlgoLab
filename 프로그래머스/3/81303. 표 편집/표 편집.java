import java.util.*;

       class Solution {
        public String solution(int n, int k, String[] cmd) {
            // n : 데이터 열 개수
            // k : 처음 선택된 인덱스
            // cmd : 명령어 배열

            // 삭제된 인덱스들은 순서대로 스택에 쌓이고, Z 명령어를 처리할 때 스택에서 삭제된 행을 복구
            Stack<Integer> deleted = new Stack<>();
            // 현재 길이, 인덱스 관리
            int size = n;
            int idx = k;

            for (String command : cmd) {
                String[] chArr = command.split(" ");

                switch (chArr[0]) {
                    // U X : 현재 선택된 행에서 X칸 위에 있는 행을 선택
                    case "U":
                        int moveUp = Integer.parseInt(chArr[1]);
                        // 위로 이동할 때 0보다 작아지지 않도록
                        idx = Math.max(0, idx - moveUp);
                        break;
                    // D X : 현재 선택된 행에서 X칸 아래에 있는 행을 선택
                    case "D":
                        int moveDown = Integer.parseInt(chArr[1]);
                        // 아래로 이동할 때 남은 행의 수를 넘지 않도록
                        idx = Math.min(size - 1, idx + moveDown);
                        break;
                    // C : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택
                    case "C":
                        // 삭제 관리 스택 적재
                        deleted.push(idx);
                        // 삭제되므로 사이즈 - 1
                        size --;
                        // 맨 마지막 행이 삭제될 경우 윗행 선택
                        if (idx == size) {  // 삭제 후 커서가 마지막 행이면 위로 이동
                            idx--;
                        }
                        break;
                    // Z : 가장 최근에 삭제된 행을 원래대로 복구 단, 현재 선택된 행은 바뀌지 않음.
                    case "Z":
                        // 삭제 관리 스택에서 제거
                        int recovered = deleted.pop();
                        // 복귀되므로 사이즈 + 1
                        size ++;
                        // 복구된 행이 커서보다 앞에 있는 경우 커서 조정
                        if(recovered <= idx) {
                            idx++;
                        }
                        break;
                }
            }
            
            StringBuilder sb = new StringBuilder("O".repeat(size));
            while (!deleted.isEmpty()) {
                sb.insert(deleted.pop(), "X");
            }
            return sb.toString();
        }
    }