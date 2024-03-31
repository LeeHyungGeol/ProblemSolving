import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] names) {
        return IntStream.iterate(0, i -> i < names.length, i-> i + 5).mapToObj(idx -> names[idx]).toArray(String[]::new);
    }
}