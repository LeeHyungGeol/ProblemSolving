import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(int[] arr, int[][] queries) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        for (int[] query : queries) {
            Collections.swap(list, query[0], query[1]);
        }
        return list;
    }
}