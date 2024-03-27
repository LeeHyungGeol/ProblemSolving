import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public List<String> solution(String my_string) {
        return IntStream.range(0, my_string.length()).mapToObj(i -> my_string.substring(i)).sorted().collect(Collectors.toList());
    }
}