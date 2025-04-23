import java.util.*;

class Solution {
    public int countLargestGroup(int n) {
        int[] counter = new int[10_001];

        for (int i = 1; i <= n; ++i) {
            counter[sumOfDigits(i)]++;
        }

        int maxLength = Arrays.stream(counter).max().getAsInt();
        int answer = 0;
        for (int i = 1; i <= n; ++i) {
            if (counter[i] == maxLength) {
                ++answer;
            }
        }

        return answer;
    }

    private int sumOfDigits(int digit) {
        int result = 0;

        while (digit > 0) {
            result += digit % 10;
            digit /= 10;
        }

        return result;
    }
}