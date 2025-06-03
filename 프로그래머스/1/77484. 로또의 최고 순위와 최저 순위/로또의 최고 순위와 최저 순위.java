import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> winNums = Arrays.stream(win_nums)   
                          .boxed()           
                          .collect(Collectors.toList());
        
        int matched = 0, zero = 0;
        for (int num : lottos) {
            if (winNums.contains(num)) {
                ++matched;
            } 
            if (num == 0) {
                ++zero;
            }
        }
        
        return new int[]{getGrade(matched+zero), getGrade(matched)};
    }
    
    private int getGrade(int matchCount) {
        switch (matchCount) {
            case 6:
                return 1;  
            case 5:
                return 2;  
            case 4:
                return 3;  
            case 3:
                return 4;  
            case 2:
                return 5;  
            default:
                return 6;  
        }
    }
}