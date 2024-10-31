import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long queueSum1 = Arrays.stream(queue1).sum();
        long queueSum2 = Arrays.stream(queue2).sum();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; ++i) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
       
        while (queueSum1 != queueSum2) {
            if (answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
            if (queueSum1 > queueSum2) {
                long value = (long) q1.poll();
                q2.add((int)value);
                queueSum1 -= value;
                queueSum2 += value;
            } else if (queueSum1 < queueSum2) {
                long value = (long) q2.poll();
                q1.add((int)value);
                queueSum1 += value;
                queueSum2 -= value;
            }
            ++answer;
        }
        
        return answer;
    }
    
}