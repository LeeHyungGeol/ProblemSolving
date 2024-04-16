import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
}