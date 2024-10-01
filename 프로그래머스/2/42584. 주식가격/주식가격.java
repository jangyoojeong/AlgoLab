import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 1. 시간 복잡도 O(N²) 풀이
        // int[] result = new int[prices.length];
        // for (int i = 0; i < prices.length; i++) {
        //     int count = 0;
        //     for (int j = i + 1; j < prices.length; j++) {
        //         count ++;
        //         if (prices[i] > prices[j]) {
        //             break;
        //         }
        //     }
        //     result[i] = count;
        // }
        // return result;

        // 2. 시간 복잡도 O(N) 풀이
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // 주식 가격이 떨어질 때 까지 반복
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                // 현재 인덱스까지의 차이를 기록
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        // 끝까지 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = prices.length - 1 - idx;
        }

        return result;
    }
}
