class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] weight = {781, 156, 31, 6, 1};       // 자리별 가중치
        char[] vowels = {'A', 'E', 'I', 'O', 'U'}; // 모음 배열

        for (int i = 0; i < word.length(); i++) {
            int charPosition = new String(vowels).indexOf(word.charAt(i));
            answer += charPosition * weight[i] + 1;
        }

        return answer;
    }
}