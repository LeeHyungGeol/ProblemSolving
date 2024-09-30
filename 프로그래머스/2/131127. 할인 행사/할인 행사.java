// 내가 한 풀이와는 조금 다르게, 가장 바깥쪽의 for 문을 반복 제어를 discount.length - 10 + 1 로 선언하고, 
// 안쪽 반복문에서 10개 동안의 갯수를 세어서 새로운 Map 을 만들어,
// 기존의 Map 과 새로 만든 Map 이 똑같은지를 비교한 풀이가 있었다.

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> counter = new HashMap<>();
        
        for (int i = 0; i < discount.length - 9; ++i) {
            for (int k = 0; k < want.length; ++k) {
                counter.put(want[k], number[k]);
            }
            for (int j = i; j < i+10; ++j) {
                // if (j >= discount.length) break;
                if (!counter.containsKey(discount[j])) break;                
                counter.put(discount[j], counter.get(discount[j])-1);
            }
            Set<Integer> set = new HashSet<>(counter.values());
            if (set.size() == 1 && set.contains(0)) ++answer;
        }
        return answer;
    }
}