import java.util.stream.*;

class Solution {
    public String solution(int[] numLog) {
        return IntStream.rangeClosed(1, numLog.length-1)
            .map(i -> (numLog[i]-numLog[i-1]))
            .mapToObj(n -> n == 1 ? "w" : n == -1 ? "s" : n == 10 ? "d" : "a")
            .collect(Collectors.joining());
    }
}