import java.util.*;

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; ++i) {
            Set<Integer> counter = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                if (counter.contains(matrix[i][j])) {
                    return false;
                }
                counter.add(matrix[i][j]);
            }
            counter = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                if (counter.contains(matrix[j][i])) {
                    return false;
                }
                counter.add(matrix[j][i]);
            }
        }

        return true;
    }
}