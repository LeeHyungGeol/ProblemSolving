import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        String answer = "";
        for (int i = 0; i < arr.length; ++i) {
            if (flag[i]) answer += String.valueOf(arr[i]).repeat(arr[i]*2);
            else answer = answer.substring(0, answer.length()-arr[i]);
        }
        return Arrays.stream(answer.split("")).mapToInt(Integer::parseInt).toArray();
    }
}