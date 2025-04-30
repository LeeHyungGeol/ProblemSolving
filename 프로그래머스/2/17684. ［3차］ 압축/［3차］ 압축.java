import java.util.*;

class Solution {
    private static Map<String, Integer> dict = new HashMap<>();
    
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        
        for (char c = 'A'; c <= 'Z'; ++c) {
            dict.put(String.valueOf(c), c-'A'+1);
        }
        
        int index = 27, left = 0;
        while (left < msg.length()) {        
            StringBuilder w = new StringBuilder();
            for (int right = left; right < msg.length(); ++right) {
                w.append(msg.charAt(right));
                
                if (!dict.containsKey(w.toString())) {
                    dict.put(w.toString(), index++);
                    if (w.length() > 1) {
                        w.deleteCharAt(w.length()-1);
                    }
                    result.add(dict.get(w.toString()));
                    break;
                }
                ++left;
            }
            if (left == msg.length()) {
                result.add(dict.get(w.toString()));
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}