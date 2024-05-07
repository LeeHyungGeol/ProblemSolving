import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranking = new HashMap<>();
        
        for (int i = 0; i < players.length; ++i) {
            ranking.put(players[i], i);
        }
        
        for (String call : callings) {
            swap(players, ranking, call);
        }
            
        return players;
    }
    
    private void swap(String[] players, Map<String, Integer> ranking, String call) {
        int idx = ranking.get(call);
        int idx2 = idx-1;
        String tmp = players[idx2];
        players[idx2] = call;
        players[idx] = tmp;
        ranking.put(call, idx2);
        ranking.put(tmp, idx);
    }
}