import java.util.*;

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        
        int[] intNums = new int[nums.length]; 
        
        for(int i = 0; i < nums.length; ++i) {
            intNums[i] = Integer.parseInt(nums[i]);
        }
        
        Arrays.sort(intNums);
        
        return intNums[0] + " " + intNums[intNums.length - 1];
    }
}