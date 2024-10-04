class Solution {
    public int solution(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if(isPrime(num)) cnt ++;
                }
            }
        }
        return cnt;
    }
    // 소수 : 1과 자기 자신 외에는 다른 수로 나누어 떨어지지 않는 자연수 (약수가 1과 자신밖에 없는 수)
    // 소수 판별 : 2부터 해당 수의 제곱근까지 나누어 떨어지는지 확인
    public boolean isPrime(int num) {
        if (num < 2) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}