import java.util.*;

class Solution {

    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> playerMap1 = new HashMap<>();
        Map<Integer, String> playerMap2 = new HashMap<>();
        
        for (int i = 0; i < players.length; i ++) 
        {
            playerMap1.put(players[i], i + 1);
            playerMap2.put(i + 1, players[i]);
        }
        
        for (int j = 0; j < callings.length; j ++) 
        {
            // 추월 한 선수
            String player1 = callings[j];
            
            // 추월 한 선수 순위
            int idx = playerMap1.get(player1);
            
            // 추월 당한 선수
            String player2 = playerMap2.get(idx - 1);
            
            playerMap1.put(player1, idx - 1);
            playerMap1.put(player2, idx);
            
            playerMap2.put(idx - 1, player1);
            playerMap2.put(idx, player2);
            
        }
        
        String[] result = new String[players.length];
        
        int idx = 0;
        for(int key : playerMap2.keySet()){
            result[idx++] = playerMap2.get(key);
        }
        
        return result;
    }
}