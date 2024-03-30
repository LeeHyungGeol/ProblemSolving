import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list) {
        return IntStream.iterate(num_list.length-1, i -> i>=0, i -> i-1).map(idx -> num_list[idx]).toArray();
    }
}