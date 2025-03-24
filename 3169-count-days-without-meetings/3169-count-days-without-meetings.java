import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        int[] prefixSum = new int[days+2];

        for (int[] meeting : meetings) {
            prefixSum[meeting[0]]++;
            prefixSum[meeting[1]+1]--;
        }

        for (int i = 2; i <= days; ++i) {
            prefixSum[i] += prefixSum[i-1]; 
        }

        int answer = 0;
        for (int i = 1; i <= days; ++i) {
            if (prefixSum[i] < 1) {
                ++answer;
            }
        }

        return answer;
    }
}