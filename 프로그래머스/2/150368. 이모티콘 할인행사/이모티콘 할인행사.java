import java.util.*;

class Solution {
    private static int[] DiscountRates = new int[]{10, 20, 30, 40};
    private static int[] Answer = new int[2];
    private static int[][] Users;
    private static int[] Emoticons;
    
    public int[] solution(int[][] users, int[] emoticons) {
        Users = users;
        Emoticons = emoticons;
        
        dfs(new int[emoticons.length], 0, emoticons.length);
        
        return Answer;
    }
    
    private void dfs(int[] discountCases, int count, int size) {
        if (count == size) {
            int subscribe = 0;
            int totalCost = 0;
            
            for (int[] user : Users) {
                int acceptableDiscount = user[0];
                int acceptablePrice = user[1];
                int sum = 0;
                
                for (int i = 0; i < Emoticons.length; ++i) {
                    int discountRate = discountCases[i];
                    if (discountRate >= acceptableDiscount) {
                        sum += Emoticons[i] / 100 * (100 - discountRate);
                    }
                }
                
                if (sum >= acceptablePrice) {
                    ++subscribe;
                } else {
                    totalCost += sum;
                }
            }            
            
            if (subscribe > Answer[0]) {
                Answer[0] = subscribe;
                Answer[1] = totalCost;
            } else if (subscribe == Answer[0]) {
                Answer[1] = Math.max(totalCost, Answer[1]);
            }
            
            return;
        }
        
        for (int i = 0; i < 4; ++i) {
            discountCases[count] = DiscountRates[i];
            dfs(discountCases, count+1, size);
        }
    }
}