import java.util.*;

class Solution {
    public int[] solution(int n) {
        HashSet<Integer> set = new HashSet<>();
        // for (int factor = 2; factor * factor <= n; factor++) {
        //     while (n % factor == 0) {
        //         set.add(factor);
        //         n /= factor;
        //     }
        // }
        // if (n > 1) {
        //     set.add(n);
        // }
        
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        
        return set.stream().mapToInt(i->i).sorted().toArray();
    }
}