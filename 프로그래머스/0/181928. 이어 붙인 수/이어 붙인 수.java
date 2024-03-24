import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        return Integer.parseInt(Arrays.stream(num_list).filter(n -> n % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining(""))) + Integer.parseInt(Arrays.stream(num_list).filter(n -> n % 2 == 1).mapToObj(String::valueOf).collect(Collectors.joining("")));
    }
}