import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        return Math.pow(IntStream.of(num_list).sum(), 2) > IntStream.of(num_list).reduce(1, (a,b) -> a*b) ? 1 : 0;
    }
}