import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> maxA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxB = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < A.length; ++i) {
            maxA.add(A[i]);
            maxB.add(B[i]);
        }
        
        while (!maxA.isEmpty()) {
            if (maxB.peek() > maxA.peek()) {
                ++answer;
                maxB.poll();
            }
            maxA.poll();
        }
        
        return answer;
    }
}