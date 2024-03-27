import java.util.*;

class Solution {
    public int solution(int[] array) {
        int max = 0, answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : array) {
            int count = map.getOrDefault(num, 0) + 1;
            
            if (count > max) {
                max = count;
                answer = num;
            }
            else if (count == max) answer = -1;
            map.put(num, count);
        }
        
        return answer;
    }
}