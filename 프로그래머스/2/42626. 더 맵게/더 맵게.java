import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i = 0; i < scoville.length; ++i) {
            pq.offer(scoville[i]);
        }
        
        boolean flag = false;
        
        while(true) {
            if(pq.peek() >= K) {
                break;
            }
            if(pq.size() < 2) {
                flag = true;
                break;
            }
            
            int min = pq.poll();
            int secondMin = pq.poll();
            
            int newMin = min + 2*secondMin;
            
            pq.offer(newMin);
            
            ++answer;
        }
        
        if(flag) {
            return -1;
        }
        
        return answer;
    }
}