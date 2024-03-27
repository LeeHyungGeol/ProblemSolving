import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int m, int c) {
        return IntStream.iterate(c-1, i <= my_string.length(), i -> i + m).mapToObj(idx -> my_string.charAt(idx)).collect(Collectors.joining());
    }
}