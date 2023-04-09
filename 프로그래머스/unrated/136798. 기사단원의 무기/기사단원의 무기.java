class Solution {
    static int countDivisors(int n, int limit, int power)
    {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {

                if (n / i == i)
                    cnt++;

                else 
                    cnt = cnt + 2;
            }
        }
        
        if (cnt > limit) 
        {
            cnt =  power;
        }

        return cnt;
    }
    
    
    public int solution(int number, int limit, int power) {
        int result = 0;
        
        for (int i = 1; i <= number; i ++) 
        {
            result += countDivisors(i, limit, power);
        }
        
        return result;
    }
}