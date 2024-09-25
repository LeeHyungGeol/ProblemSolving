import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int[] arrA = Arrays.stream(A).sorted().toArray();
        int[] arrB = Arrays.stream(B).sorted().toArray();
        int answer = 0;
        
        for (int i = 0; i < arrA.length; ++i) {
            answer += arrA[i] * arrB[arrA.length-1-i];
        }
        return answer;
    }
}