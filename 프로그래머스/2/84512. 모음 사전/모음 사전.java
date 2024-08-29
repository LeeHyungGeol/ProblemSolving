import java.util.*;

class Solution {
    static List<String> Dict = new ArrayList<>();
    static String Vowel = "AEIOU";
    
    public int solution(String word) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder("");
        
        dfs(sb, 0);
        
        for(int i = 0; i < Dict.size(); ++i) {
            if(Dict.get(i).equals(word)) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
    
    private void dfs(StringBuilder w, int cnt) {
        if(cnt == 5) {
            return;
        }
        
        for(int i = 0; i < 5; ++i) {
            w.append(Vowel.charAt(i));
            Dict.add(w.toString());
            dfs(w, cnt + 1);
            w.deleteCharAt(w.length()-1);
        }
    }
}