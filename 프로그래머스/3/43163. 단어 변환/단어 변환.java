import java.util.*;

class Solution {
    private static int Answer = (int) 1e9;
    private static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return Answer == (int) 1e9 ? 0 : Answer;
    }
    
    private void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            Answer = Math.min(Answer, count);
            return;
        }
        
        for (int i = 0; i < words.length; ++i) {
            if (visited[i]) continue;
            if (isOnlyOneWordDifferent(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isOnlyOneWordDifferent(String a, String b) {
        int count = 0;
        
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                ++count;
            }
        }
        
        return count == 1 ? true : false;
    }
}