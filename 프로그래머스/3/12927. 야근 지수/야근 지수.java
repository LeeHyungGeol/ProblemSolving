import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        
        for (int work : works) {
            pq.add(work);
        }
        
        while(n > 0) {
            if (pq.isEmpty()) break;
            --n;
            int work = pq.poll();
            --work;
            if (work > 0) {
                pq.add(work);
            }
        }
        
        while (!pq.isEmpty()) {
            answer += (long) Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}