import java.util.*;

class Solution {
    private static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        dfs(numbers, visited, "", 0);
        
        for (Integer number : set) {
            if (isPrime(number)) {
                ++answer;
            }
        }
        
        return answer;
    }
    
    private void dfs(String numbers, boolean[] visited, String number, int depth) {
        if (depth > numbers.length()) {
            return;
        }
 
        for (int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            set.add(Integer.parseInt(number + numbers.charAt(i)));
            dfs(numbers, visited, number + numbers.charAt(i), depth + 1);
            visited[i] = false;
        }
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
 
        return true;
    }
}