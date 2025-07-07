import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            dict.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> answer = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : dict.entrySet()) {
            answer.add(entry.getValue());
        }

        return answer;
    }
}