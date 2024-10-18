// PriorityQueue 는 기본적으로 오름차순 정렬
import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        while (!(pq.peek() >= K)) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            
            if (second == 0) {
                answer = -1;
                break;
            }
                        
            pq.offer(mix(first, second));
            ++answer;
        }
        
        
        return answer;
    }
    
    private int mix(int first, int second) {
        return first + (second * 2);
    }
}