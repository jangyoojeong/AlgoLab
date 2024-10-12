import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i ++) {
            queue.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        int count = 0;

        while(!queue.isEmpty()) {
            count ++;
            int current = queue.poll();

            if (count == K) {
                result.append(current);
                count = 0;
                if(!queue.isEmpty()) {
                    result.append(", ");
                }
            }
            else {
                queue.add(current);
            }
        }

        result.append(">");
        System.out.println(result);
    }
}