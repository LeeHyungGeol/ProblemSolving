import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int m, int c) {
        return IntStream.iterate(c-1, i -> i <= my_string.length()-1, i -> i + m).mapToObj(idx -> String.valueOf(my_string.charAt(idx))).collect(Collectors.joining());
    }
}