import java.util.stream.IntStream;

class Solution {
    public String[] solution(String my_string) {
        return IntStream.range(0, my_string.length()).mapToObj(i -> my_string.substring(i)).sorted().toArray(String[]::new);
    }
}