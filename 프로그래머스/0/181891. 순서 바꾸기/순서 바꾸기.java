import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream.concat(Arrays.stream(num_list, n, num_list.length), Arrays.stream(num_list, 0, n)).toArray();
    }
}