class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;
        
        int reCnt = 0;
        int holdCnt = n;
        
        while(true)
        {
            // 돌려받는 병 개수
            reCnt = (holdCnt / a) * b;
            
            holdCnt = holdCnt - (holdCnt - (holdCnt % a)) + reCnt;

            
            result += reCnt;
            
            if (holdCnt < a) 
            {
                break;
            }
        }
        
        return result;
    }
}