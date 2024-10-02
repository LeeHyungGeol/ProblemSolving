import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int maxCount = 0;
        int length = dungeons.length;

        // Create a list of indices to generate permutations
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            indices.add(i);
        }

        // Generate all permutations of dungeon indices
        List<List<Integer>> permutations = getPermutations(indices);
        
        // Evaluate each permutation
        for (List<Integer> perm : permutations) {
            int tk = k;
            int count = 0;

            for (int i : perm) {
                if (tk < dungeons[i][0]) {
                    break;
                }
                tk -= dungeons[i][1];
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // Helper function to generate all permutations
    private List<List<Integer>> getPermutations(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(list, 0, result);
        return result;
    }

    // Helper function to recursively generate permutations
    private void permuteHelper(List<Integer> list, int start, List<List<Integer>> result) {
        if (start == list.size() - 1) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, i, start);
            permuteHelper(list, start + 1, result);
            Collections.swap(list, i, start);
        }
    }
}
