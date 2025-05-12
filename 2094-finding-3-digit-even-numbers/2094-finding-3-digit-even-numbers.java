import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int digitsLength = digits.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < digitsLength; ++i) {
            for (int j = 0; j < digitsLength; ++j) {
                for (int k = 0; k < digitsLength; ++k) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    String num = new StringBuilder().append(digits[i]).append(digits[j]).append(digits[k]).toString();
                    int n = Integer.parseInt(num);

                    if (num.charAt(0) != '0' && !set.contains(n) && n % 2 == 0) {
                        set.add(n);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>(set);
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for (int i = 0; i < answer.length; ++i) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}