import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] secondLine = bufferedReader.readLine().split(" ");
        int[] pizzas = Arrays.stream(secondLine).mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.toString(timeToFinishPizza(N, pizzas)).replaceAll("[\\[\\],]", ""));
    }

    public static int[] timeToFinishPizza(int N, int[] pizzas) {
        Queue<People> queue = new LinkedList<>();
        int[] result = new int[N];
        int time = 0; // 전체 경과 시간을 추적하는 변수

        // 참가자 초기화
        for (int i = 0; i < pizzas.length; i++) {
            queue.add(new People(pizzas[i], i));
        }

        // 피자 배분 시작
        while (!queue.isEmpty()) {
            time++; // 매 초마다 전체 경과 시간 증가
            People people = queue.poll();
            people.pizza--; // 피자 조각 한 개 소모

            if (people.pizza == 0) {
                result[people.index] = time; // 해당 참가자가 피자를 다 먹은 시간 기록
            } else {
                queue.add(people); // 피자가 남아있다면 다시 줄 끝에 추가
            }
        }

        return result;
    }

    public static class People {
        int pizza; // 필요한 피자 개수
        int index; // 참가자 인덱스

        public People(int pizza, int index) {
            this.pizza = pizza;
            this.index = index;
        }
    }
}