import java.util.*;

class Solution {
    private int Answer;

    public int subsetXORSum(int[] nums) {
        Answer = 0;

        makeSubset(0,0, nums);

        return Answer;
    }

    private void makeSubset(int start, int num, int[] nums) {
        Answer += num;

        for (int i = start; i < nums.length; ++i) {
            makeSubset(i+1, num ^ nums[i], nums);
        }
    }
}