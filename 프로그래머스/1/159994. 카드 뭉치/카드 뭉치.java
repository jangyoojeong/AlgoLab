import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> cards1Queue = new LinkedList<>();
        Queue<String> cards2Queue = new LinkedList<>();

        for (String card1 : cards1) {
            cards1Queue.add(card1);
        }

        for (String card2 : cards2) {
            cards2Queue.add(card2);
        }

        for (String g : goal) {
            if (!cards1Queue.isEmpty() && g.equals(cards1Queue.peek())) {
                cards1Queue.poll();
            } else if (!cards2Queue.isEmpty() && g.equals(cards2Queue.peek())) {
                cards2Queue.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}