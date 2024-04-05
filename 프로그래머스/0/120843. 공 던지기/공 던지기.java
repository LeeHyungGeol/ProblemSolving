class Solution {
    public int solution(int[] numbers, int k) {
        // return numbers[(2 * (k - 1)) % numbers.length];
        int answer = 1, idx = 0;
        for (int i = 0; i < k-1; ++i) {
            idx += 2;
            if (idx > numbers.length-1) idx -= numbers.length;
        }
        return numbers[idx];
    }
}