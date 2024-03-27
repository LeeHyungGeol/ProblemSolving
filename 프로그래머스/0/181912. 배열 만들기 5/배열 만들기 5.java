import java.util.Arrays;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs).mapToInt(str -> Integer.parseInt(str.substring(s, s+l))).filter(n -> n > k).toArray();
    }
}