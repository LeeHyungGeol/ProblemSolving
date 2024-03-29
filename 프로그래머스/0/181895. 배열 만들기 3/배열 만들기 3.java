import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        return IntStream.concat(Arrays.stream(arr, intervals[0][0], intervals[0][1]+1), Arrays.stream(arr, intervals[1][0], intervals[1][1]+1)).toArray();
    }
}