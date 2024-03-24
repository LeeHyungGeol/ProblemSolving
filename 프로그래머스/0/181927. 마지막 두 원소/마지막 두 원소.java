import java.util.*;
import java.util.stream.*;
import java.lang.Integer;

class Solution {
    public int[] solution(int[] num_list) {
        return IntStream.iterate(0, i -> i + 1)
                        .limit(num_list.length + 1)
                        .map(i -> i == num_list.length ? (num_list[i - 1] > num_list[i - 2] ? num_list[i - 1] - num_list[i - 2] : 2 * num_list[i - 1]) : num_list[i])
                        .toArray();
    }
}