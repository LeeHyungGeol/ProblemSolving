import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        int[] tmp = IntStream.range(0, arr.length).filter(i -> arr[i] == 2).toArray();
        return tmp.length == 0 ? new int[]{-1} : Arrays.stream(arr, tmp[0], tmp[tmp.length-1]+1).toArray();
    }
}