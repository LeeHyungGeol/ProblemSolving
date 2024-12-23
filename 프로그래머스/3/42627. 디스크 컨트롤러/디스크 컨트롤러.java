import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int index = 0, duration = 0, answer = 0;
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]);
        
        while(!pq.isEmpty() || index < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= duration) {
                pq.add(jobs[index++]);
            }
            if (pq.isEmpty()) {
                duration = jobs[index][0];
                pq.add(jobs[index++]);
            } else {
                int[] currentTask = pq.poll();
                duration += currentTask[1];
                answer += (duration - currentTask[0]);
            }
        } 
        
        return answer / jobs.length;
    }
}