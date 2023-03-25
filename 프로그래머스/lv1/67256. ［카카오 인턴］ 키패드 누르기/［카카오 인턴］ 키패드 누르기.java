class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int l = 10;
        int r = 12;
        
        for (int i = 0; i < numbers.length; i ++) 
        {
            int n = numbers[i];
            
            if (n == 1 || n == 4 || n == 7) 
            {
                l = n;
                sb.append("L");
            }
            if (n == 3 || n == 6 || n == 9) 
            {
                r = n;
                sb.append("R");
            }
            if (n == 2 || n == 5 || n == 8 || n == 0) 
            {
                if (n == 0) n = 11;

                int leftDiff = (Math.abs(n - l) / 3) + (Math.abs(n - l) % 3);
                int rightDiff = (Math.abs(n - r) / 3) + (Math.abs(n - r) % 3);
                
                if (leftDiff == rightDiff) 
                {
                    if (hand.equals("right")) 
                    {
                        r = n;
                        sb.append("R");
                    }
                    else
                    {
                        l = n;
                        sb.append("L");
                    }
                }
                else if (leftDiff > rightDiff) 
                {
                    r = n;
                    sb.append("R");
                }
                else
                {
                    l = n;
                    sb.append("L");
                }
                
            }
        }   

        return sb.toString();
    }
}