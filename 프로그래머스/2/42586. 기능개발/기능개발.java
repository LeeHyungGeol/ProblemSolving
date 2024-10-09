import java.util.*;

class Solution {
    
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Double> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; ++i) {
            queue.add(Math.ceil((double)(100-progresses[i])/speeds[i]));
        }
        
        int count = 1;
        double current = queue.poll();
        
        while (!queue.isEmpty()) {
            if (queue.peek() > current) {
                answer.add(count);
                current = queue.poll();
                count = 1;
            } else {
                ++count;
                queue.poll();
            }
        }
        
        answer.add(count);
        
        return answer;
    }
}