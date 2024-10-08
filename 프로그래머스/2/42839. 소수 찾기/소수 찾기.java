import java.util.*;

class Solution {

    // 11과 011은 같은 숫자로 취급하기 때문에 HashSet을 이용하여 중복제거
    private Set<Integer> hs = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, visited, new StringBuilder());

        int answer = 0;
        for (int n : hs) {
            if (isPrime(n)) answer++;
        }
        return answer;
    }

    private void dfs (String numbers, boolean[] visited, StringBuilder current) {

        if (current.length() > 0) {
            int num = Integer.parseInt(current.toString());
            hs.add(num);
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.append(numbers.charAt(i));
                dfs(numbers, visited, current);
                current.deleteCharAt(current.length() - 1);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    private boolean isPrime (int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}