import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        // return Arrays.stream(num_list).sorted().limit(5).toArray();
        
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list,0,5);
    }
}