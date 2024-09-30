import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Set<String>> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; ++i) {
            map.computeIfAbsent(clothes[i][1], k -> new HashSet<>()).add(clothes[i][0]);
        }
        
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            answer *= entry.getValue().size()+1;
        }
        
        return --answer;
    }
}