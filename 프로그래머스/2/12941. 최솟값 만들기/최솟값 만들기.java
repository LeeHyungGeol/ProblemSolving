import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        Integer[] b = Arrays.stream(B).boxed().toArray(Integer[]::new); 

        Arrays.sort(A);
        Arrays.sort(b, Collections.reverseOrder());
        
        for(int i = 0; i < A.length; ++i) {
            answer += A[i] * b[i];
        }
        
        return answer;
    }
}