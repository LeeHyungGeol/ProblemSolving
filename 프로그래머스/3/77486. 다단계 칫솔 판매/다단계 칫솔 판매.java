import java.util.*;

class Solution {
    private Map<String, String> tree = new HashMap<>();
    private Map<String, Integer> amounts = new HashMap<>();
        
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; ++i) {
            tree.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; ++i) {
            getProfit(seller[i], amount[i]*100);
        } 
         
        for (int i = 0; i < enroll.length; ++i) {
            answer[i] = amounts.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    
    private void getProfit(String seller, int profit) {
        if ("-".equals(seller) || profit == 0) {
            return;
        }
        
        int remain = (int) (profit * 0.1);
        amounts.put(seller, amounts.getOrDefault(seller, 0) + profit-remain);
        getProfit(tree.getOrDefault(seller, "-"), remain);
    }
}