import java.util.*;

class Solution {

    public int bfs(int start, int ignore, ArrayList<ArrayList<Integer>> graph, int n) {
        boolean[] visited = new boolean[n + 1];         // 방문 여부 기록 배열
        Queue<Integer> queue = new LinkedList<>();  // BFS 큐
        queue.add(start);               // 시작 노드 큐에 추가
        visited[start] = true;          // 시작 노드 방문 표시
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();    // 큐에서 노드 하나 꺼냄
            count++;
            System.out.print(node + " ");

            // 연결된 이웃 노드 탐색
            for (int neighbor : graph.get(node)) {
                // 특정 간선을 건너뜀 (간선 끊기)
                if (!visited[neighbor] && neighbor != ignore) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return count;
    }

    public int solution(int n, int[][] wires) {

        // 트리 형태로 연결된 송전탑을 끊어서 2개로 분할할때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추는 경우의 차이
        // 하나씩 끊어서 절대값 min을 찾아야 하나

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가 (양방향)
        for (int[] w : wires) {
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("Node " + i + " is connected to " + graph.get(i));
        }

        int minDifference = n;  // 최대 노드 개수로 초기화

        // 각 간선을 끊어가며 최소 차이를 찾는다
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            // 특정 간선을 끊고 BFS 실행
            int count1 = bfs(a, b, graph, n);
            int count2 = n - count1;
            minDifference = Math.min(minDifference, Math.abs(count1 - count2));
        }
        return minDifference;
    }
}