import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> map = new HashMap<>();
        
        for (String keys : keymap) {
            for (String key : keys.split("")) {
                if (map.containsKey(key)) map.put(key, Math.min(keys.indexOf(key)+1, map.get(key)));
                else map.put(key, keys.indexOf(key)+1);
            }
        }
        
        for (int i = 0; i < targets.length; ++i) {
            int cnt = 0;
            for (String target : targets[i].split("")) {
                if (map.containsKey(target)) cnt += map.get(target);
                else {
                    cnt = -1;
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}