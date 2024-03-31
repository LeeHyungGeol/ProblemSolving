import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        return Math.max(IntStream.iterate(0, i -> i < num_list.length, i -> i + 2).map(idx -> num_list[idx]).sum(), IntStream.iterate(1, i -> i < num_list.length, i -> i + 2).map(idx -> num_list[idx]).sum());
    }
}