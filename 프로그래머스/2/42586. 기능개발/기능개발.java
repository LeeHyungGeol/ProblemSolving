import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; ++i) {
            int days = (100-progresses[i]) / speeds[i];
            
            if(((100-progresses[i]) % speeds[i]) != 0) {
                ++days;
            }
            q.offer(days);
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            int cnt = 1;
            
            while(!q.isEmpty() && cur >= q.peek()) {
                ++cnt;
                q.poll();
            }
            
            answer.add(cnt);
        }
        
        return answer;
    }
}