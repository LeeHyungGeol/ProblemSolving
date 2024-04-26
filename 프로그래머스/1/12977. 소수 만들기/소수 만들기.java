import java.util.*;

class Solution {
    private static int answer = 0;
    
    public int solution(int[] nums) {
        comb(nums, new int[3], 0,3,0);
        return answer;
    }
    
    private void comb(int[] nums, int[] selected, int cnt, int limit, int start) {
        if(cnt == limit) {
            int sum = Arrays.stream(selected).sum();
            if (isPrime(sum))
                ++answer;
            return;
        }
        
        for(int i = start; i < nums.length; ++i) {
            selected[cnt] = nums[i];
            comb(nums, selected, cnt+1, limit, i+1);
        }
    }
    
    private boolean isPrime(int n) {
        for (int i = 2; i*i <= n; ++i) {
            if(n%i == 0) return false;
        }
        return true;
    } 
}