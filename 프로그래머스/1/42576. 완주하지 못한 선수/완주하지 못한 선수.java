import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> counter = new HashMap<>();
        
        for (String c : completion) {
            counter.put(c, counter.getOrDefault(c, 0)+1);
        }
        
        for (String p : participant) {
            counter.put(p, counter.getOrDefault(p, 0)-1);
        }
        
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == -1) {
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}