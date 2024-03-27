import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(int q, int r, String code) {
        return IntStream.range(0, code.length()).filter(i -> i % q == r).mapToObj(idx -> String.valueOf(code.charAt(idx))).collect(Collectors.joining());
    }
}