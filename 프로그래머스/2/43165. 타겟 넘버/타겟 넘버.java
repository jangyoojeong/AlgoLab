class Solution {

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int currentSum) {
        // 모든 숫자를 다 사용했을 때
        if (index == numbers.length) {
            // target과 일치하면 1, 그렇지 않으면 0 반환
            return currentSum == target ? 1 : 0;
        }

        // 더하는 경우와 빼는 경우의 결과를 합산하여 반환
        int add = dfs(numbers, target, index + 1, currentSum + numbers[index]);
        int subtract = dfs(numbers, target, index + 1, currentSum - numbers[index]);

        return add + subtract;
    }
}