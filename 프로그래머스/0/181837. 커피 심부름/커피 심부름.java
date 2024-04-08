import java.util.Arrays;

class Solution {
    public int solution(String[] order) {
        return Arrays.stream(order).mapToInt(i -> i.contains("cafelatte") ? 5000 : 4500).sum();
    }
}