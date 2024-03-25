import java.util.stream.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = IntStream.rangeClosed(l,r)
            .filter(n -> String.valueOf(n).chars().allMatch(c -> c == '0' || c == '5'))
            .toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
}