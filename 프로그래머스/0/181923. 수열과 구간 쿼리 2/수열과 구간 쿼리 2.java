import java.util.*;
import java.util.stream.*;

class Solution {
    public List<Integer> solution(int[] arr, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < queries.length; ++i) {
            int s = queries[i][0], e = queries[i][1], k = queries[i][2];
            answer.add(Arrays.stream(arr).skip(s).limit(e-s+1).sorted().filter(n -> n > k).findFirst().orElse(-1));
        }
        return answer;
    }
}