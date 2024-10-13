import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        System.out.println(getDiscardOrder(N));
    }

    public static String getDiscardOrder (int N) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i ++) {
            queue.add(i);
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            result.append(queue.poll());
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
                result.append(" ");
            }
        }
        return result.toString();
    }
}