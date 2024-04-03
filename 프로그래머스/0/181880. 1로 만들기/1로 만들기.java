import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        return Arrays.stream(num_list).map(n -> {
            int cnt = 0;
            while (n > 1) {
                if (n % 2 == 0) n /= 2;
                else n = (n-1)/2;
                ++cnt;
            }
            return cnt;
        }).sum();
    }
}