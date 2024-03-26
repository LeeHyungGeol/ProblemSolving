import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        return IntStream.iterate(n, i -> i >= 1, i -> i == 1 ? 0 : i % 2 == 0 ? i / 2 : 3 * i + 1).toArray();
                    // Stream.iterate(n, i -> i >= 1, i -> i == 1 ? 0 : i % 2 == 0 ? i / 2 : 3 * i + 1).mapToInt(Integer::intValue).toArray();

    }
}