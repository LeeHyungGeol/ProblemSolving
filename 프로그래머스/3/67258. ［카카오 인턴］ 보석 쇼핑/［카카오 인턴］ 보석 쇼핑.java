import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int distance = Integer.MAX_VALUE, start = 0, end = 0;
        int totalGemKind = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> gemCounter = new HashMap<>();
        
        while (true) {
            if (end == gems.length) {
                break;
            }
            
            gemCounter.put(gems[end], gemCounter.getOrDefault(gems[end], 0) + 1);
            
            while(gemCounter.get(gems[start]) > 1) {
                gemCounter.put(gems[start], gemCounter.get(gems[start]) - 1);
                ++start;
            }
            
            if (gemCounter.size() == totalGemKind && end-start < distance) {
                distance = end-start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
            
            ++end;
        }
        
        
        return answer;
    }
}