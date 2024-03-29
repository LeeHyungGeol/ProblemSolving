import java.util.stream.IntStream;
import java.util.*;

class Solution {
    public int[] solution(int start, int end_num) {
         return IntStream.rangeClosed(end_num, start).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
    }
}