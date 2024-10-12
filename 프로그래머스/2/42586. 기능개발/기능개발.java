import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();

        // 각 작업의 남은 일수를 계산하여 큐에 추가
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.add(days);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int days = queue.poll();
            int count = 1;

            // 같은 날 배포할 수 있는 작업 찾기
            while(!queue.isEmpty() && queue.peek() <= days) {
                queue.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}