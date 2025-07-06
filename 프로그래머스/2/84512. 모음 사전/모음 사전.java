import java.util.*;

class Solution {
    private static List<String> Words = new ArrayList<>();
    private static String[] Vowels = {"A","E","I","O","U"};
    
    public int solution(String word) {
        int answer = 0;
        
        backtracking(new StringBuilder(), 0);
        
        for (int i = 0; i < Words.size(); ++i) {
            if (word.equals(Words.get(i))) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
    
    private void backtracking(StringBuilder sb, int depth) {
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < 5; ++i) {
            sb.append(Vowels[i]);
            Words.add(sb.toString());
            backtracking(sb, depth+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}