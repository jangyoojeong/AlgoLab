import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        // 1번 ~ 3번 수포자 답안 패턴
        // 1번 수포자 1~5 반복
        // 2번 수포자 2, 1, 2, 3, 2, 4, 2, 5 반복
        // 3번 수포자 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복
        int[] case1 = {1, 2, 3, 4, 5};
        int[] case2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] case3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 각 수포자의 점수 배열
        int[] scores = new int[3];

        // 시간 복잡도 O(n)
        for (int i = 0; i < answers.length; i++) {
            if (case1[i % case1.length] == answers[i]) {
                scores[0] ++;
            }
            if (case2[i % case2.length] == answers[i]) {
                scores[1] ++;
            }
            if (case3[i % case3.length] == answers[i]) {
                scores[2] ++;
            }
        }

        // 최대 점수 찾기
        int maxScore = 0;
        for (int score : scores) {
            maxScore = Math.max(maxScore, score);
        }

        // 최대 점수를 받은 수포자들 찾기
        List<Integer> topScorers = new ArrayList<>();
        for (int i = 0; i < scores.length; i ++) {
            if (scores[i] == maxScore) {
                topScorers.add(i + 1);
            }
        }

        // 결과 반환
        int[] result = new int[topScorers.size()];
        for (int i = 0; i < topScorers.size(); i++) {
            result[i] = topScorers.get(i);
        }
        return result;
    }
}