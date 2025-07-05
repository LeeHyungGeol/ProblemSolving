import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothCounter = new HashMap<>();
        
        for (int i = 0; i < clothes.length; ++i) {
            clothCounter.put(clothes[i][1], clothCounter.getOrDefault(clothes[i][1], 0)+1);
        }
        
        for (int count : clothCounter.values()) {
            answer *= count+1;
        }
        
        return answer-1;
    }
}