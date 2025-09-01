class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = 0;
        int sum = 0;

        for (right = 0; right < numbers.length; ++right) {
            sum += numbers[right];

            while (sum > target) {
                sum -= numbers[left++];
            }
            
            if (sum == target) {
                if (left == right) {
                    right = left + 1;
                }
                break;
            }

            if (right > 0) {
                sum -= numbers[right];
            }
        }

        return new int[]{left+1, right+1};
    }
}