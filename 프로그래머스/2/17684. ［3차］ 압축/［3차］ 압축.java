import java.util.*;

class Solution {
    public static Map<String, Integer> dictionary = new HashMap<>(){{
        put("A", 1);
        put("B", 2);
        put("C", 3);
        put("D", 4);
        put("E", 5);
        put("F", 6);
        put("G", 7);
        put("H", 8);
        put("I", 9);
        put("J", 10);
        put("K", 11);
        put("L", 12);
        put("M", 13);
        put("N", 14);
        put("O", 15);
        put("P", 16);
        put("Q", 17);
        put("R", 18);
        put("S", 19);
        put("T", 20);
        put("U", 21);
        put("V", 22);
        put("W", 23);
        put("X", 24);
        put("Y", 25);
        put("Z", 26);
    }};
    
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        msg = msg.toUpperCase();
        int index = 27, next = 0;
        
        while(next < msg.length()) {
            sb = new StringBuilder();
            
            for (int i = next; i < msg.length(); ++i) {
                sb.append(msg.charAt(next));
                String wc = sb.toString();
            
                if (!dictionary.containsKey(wc)) {
                    answer.add(findIndex(getW(wc)));
                    dictionary.put(wc, index++);
                    break;
                }
                ++next;
            }
            if (next == msg.length()) {
                answer.add(findIndex(sb.toString()));
            }
        }
        
        return answer;
    }
    
    private String getW(String word) {
        return word.substring(0, word.length()-1);
    }
    
    private Integer findIndex(String w) {
        return dictionary.get(w);
    }
}