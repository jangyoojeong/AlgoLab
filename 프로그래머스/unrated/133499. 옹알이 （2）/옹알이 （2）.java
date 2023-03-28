class Solution {
    public int solution(String[] babbling) {
        int result = 0;

        for (String txt1 : babbling)
        {
            // 같은 발음 연속 체크
            if(txt1.contains("ayaaya") || txt1.contains("yeye") || txt1.contains("woowoo") || txt1.contains("mama")) {
                continue;
            }
            
            // "aya", "ye", "woo", "ma" 4가지 발음 가능
            txt1 = txt1.replace("aya", " ");
            txt1 = txt1.replace("ye", " ");
            txt1 = txt1.replace("woo", " ");
            txt1 = txt1.replace("ma", " ");
            txt1 = txt1.replace(" ", "");
            
            
            if (txt1.length() == 0) result++;
            
        }     
        
        
        

        
        return result;
    }
}