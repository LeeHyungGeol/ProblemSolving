import java.util.*;

class Solution {
    private static Set<Integer> set = new HashSet<>(); 
    
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        for (int i = 1; i <= numbers.length(); ++i) {
            dfs(numbers, "", visited, i);
        }
        
        return set.size();
    }
    
    private void dfs(String numbers, String number, boolean[] visited, int size) {
        if (size == number.length()) {
            int n = Integer.parseInt(number);
            if (isPrime(n)) {
                set.add(n);
            }
            return;
        }
        
        for (int i = 0; i < numbers.length(); ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(numbers, number + numbers.charAt(i), visited, size);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i*i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}