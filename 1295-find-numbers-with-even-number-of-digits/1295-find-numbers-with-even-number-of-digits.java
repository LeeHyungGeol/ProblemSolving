class Solution {
    public int findNumbers(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            if (countDigits(num) % 2 == 0) {
                ++answer;
            }
        }

        return answer;
    }

    private int countDigits(int num) {
        int result = 0;

        while (num != 0) {
            num /= 10;
            ++result;
        }

        return result;
    }
}