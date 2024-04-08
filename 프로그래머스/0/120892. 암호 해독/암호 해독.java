import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String cipher, int code) {
        return IntStream.iterate(code-1, i -> i < cipher.length(), i -> i += code).mapToObj(i -> String.valueOf(cipher.charAt(i))).collect(Collectors.joining());
    }
}