class Solution {
    public int[] solution(int[] array) {
        int answer = 0, index = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > answer) {
                answer = array[i];
                index = i;
            }
        }
        return new int[]{answer, index};
    }
}