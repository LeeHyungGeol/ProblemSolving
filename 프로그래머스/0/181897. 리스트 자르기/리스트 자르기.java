import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        if (n == 1) return Arrays.stream(num_list, 0, slicer[1] + 1).toArray();
        else if (n == 2) return Arrays.stream(num_list, slicer[0], num_list.length).toArray();
        else if (n==3) return Arrays.stream(num_list, slicer[0], slicer[1] + 1).toArray();
        else return IntStream.iterate(slicer[0], i -> i <= slicer[1], i -> i + slicer[2]).map(idx -> num_list[idx]).toArray();
    }
}