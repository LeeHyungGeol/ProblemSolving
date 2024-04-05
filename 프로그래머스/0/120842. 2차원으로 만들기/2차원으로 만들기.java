import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        // int[][] answer = new int[num_list.length/n][];
        // for (int i=0,j=0; i<num_list.length; ++j,i+=n) {
        //     answer[j] = Arrays.copyOfRange(num_list, i, i+n);
        // }
        // return answer;
        
        return IntStream.range(0, num_list.length / n)
                .mapToObj(i -> IntStream.range(0, n)
                        .map(j -> num_list[i * n + j])
                        .toArray())
                .toArray(int[][]::new);
    }
}