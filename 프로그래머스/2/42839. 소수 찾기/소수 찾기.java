import java.util.*;

class Solution {
    private static Set<Integer> answer = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        for (int i = 1; i <= numbers.length(); ++i) {
            backtracking(numbers, "", visited, i);
        }
        
        return answer.size();
    }
    
    private void backtracking(String numbers, String n, boolean[] visited, int size) {
        if (size == n.length() && isPrime(Integer.parseInt(n))) {
            answer.add(Integer.parseInt(n));
            return;
        }
        
        for (int i = 0; i < numbers.length(); ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            backtracking(numbers, n + numbers.charAt(i), visited, size);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false; 

        int sqrt = (int) Math.sqrt(n);
        
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}