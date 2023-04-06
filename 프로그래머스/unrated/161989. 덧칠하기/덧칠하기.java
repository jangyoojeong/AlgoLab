class Solution {
    public int solution(int n, int m, int[] section) {
        int paint = section[0];
        int result = 1;
        
        for (int i = 0; i < section.length; i ++) 
        {
            if (paint + m - 1 < section[i]) 
            {
                result ++;
                paint = section[i];
            }
        }
        
        return result;
    }
}