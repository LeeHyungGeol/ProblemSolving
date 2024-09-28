import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, ((o1,o2) -> (map.get(o2)-map.get(o1))));
        
        for (Integer i : list) {
            if (k <= 0) break;
            ++answer;
            k -= map.get(i);
        }
        
        return answer;
    }
}