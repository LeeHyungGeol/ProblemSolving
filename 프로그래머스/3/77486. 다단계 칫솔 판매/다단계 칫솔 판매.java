import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> tree = new HashMap<>();
        Map<String, Integer> results = new HashMap<>();
        
        for (int i = 0; i < enroll.length; ++i) {
            String current = enroll[i];
            String next = referral[i];
            tree.put(current, next);
            results.put(current, 0);
        }
        
        for (int i = 0; i < seller.length; ++i) {
            dfs(seller[i], amount[i]*100, tree, results);
        }
        
        for (int i = 0; i < enroll.length; ++i) {
            answer[i] = results.get(enroll[i]);
        }
        
        return answer;
    }
    
    private void dfs(String seller, int amount, Map<String, String> tree, Map<String, Integer> results) {
        if (seller.equals("-") || amount == 0) {
            return;
        }
        int rest = amount / 10;
        results.put(seller, results.get(seller) + (amount - rest));
        dfs(tree.get(seller), rest, tree, results);
    }
}