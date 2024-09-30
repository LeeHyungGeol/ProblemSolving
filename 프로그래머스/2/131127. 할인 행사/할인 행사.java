import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> counter = new HashMap<>();
        
        for (int i = 0; i < discount.length; ++i) {
            for (int k = 0; k < want.length; ++k) {
                counter.put(want[k], number[k]);
            }
            for (int j = i; j < i+10; ++j) {
                if (j >= discount.length) break;
                if (!counter.containsKey(discount[j])) break;                
                counter.put(discount[j], counter.get(discount[j])-1);
            }
            Set<Integer> set = new HashSet<>(counter.values());
            if (set.size() == 1 && set.contains(0)) ++answer;
        }
        return answer;
    }
}