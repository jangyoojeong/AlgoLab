import java.util.*;

class Solution {

    public int[] solution(int n, long k) {
        // 1. 전체 순서 조합의 수 : n개의 숫자로 만들 수 있는 모든 순열의 수는 n!. 따라서 k번째 순서를 찾을 때 각 자리에서 몇 가지 경우의 수가 있는지 계산해야 함.
        // 2. 자리마다 가능한 경우 수 줄이기 : 예를 들어, 첫 자리를 고정하면 나머지 (n-1)!만큼의 경우의 수가 남으므로, k가 해당 범위에 있는지 확인하면서 줄여나감.
        // 팩토리얼(n!) : 어떤 정수 n 에 대해 1부터 n 까지의 모든 수를 곱한 값

        int[] answer = new int[n];
        List<Integer> arrayList = new ArrayList();

        for (int i = 1; i <= n; i ++) {
            arrayList.add(i);
        }

        k--;
        long facktorial = 1;

        for (int i = 1; i <= n-1; i ++) {
            facktorial *= i;
        }

        for (int i = 0; i < n; i ++) {
            int index = (int)(k / facktorial);
            answer[i] = arrayList.get(index);
            arrayList.remove(index);

            // 마지막꺼는 다음항목을 위한 변수를 갱신해 줄 필요 없음.
            if (i < n - 1) {
                k %= facktorial;
                facktorial /= (n - 1 - i);
            }
        }

        return answer;
    }
}