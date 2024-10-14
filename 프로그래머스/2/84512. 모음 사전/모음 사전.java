import java.util.*;

class Solution {
    private static String[] vowel = {"A", "E", "I", "O", "U"};
    private static Map<String, Integer> dictionary = new HashMap<>();
    private static int index = 0;

    public int solution(String word) {
        dfs(new StringBuilder());
        return dictionary.get(word);
    }
    
    private void dfs(StringBuilder word) {
        if (word.length() == 5) {
            return;
        }
        
        for (int i = 0; i < 5; ++i) {
            word.append(vowel[i]);
            if (!dictionary.containsKey(word.toString())) {
                dictionary.put(word.toString(), ++index);
            }
            dfs(word);
            word.deleteCharAt(word.length()-1);
        }
    }
}