import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        boolean flag = false;
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; ++i) {
            q.add(new Node(priorities[i], i));
            pq.add(priorities[i]);
        }
        
        while(true) {
            Node fileSequence = q.peek();
            int priority = pq.peek();
            
            if(priority > fileSequence.getPriority()) {
                q.add(fileSequence);
                q.poll();
            }
            else {
                if(fileSequence.getSeq() == location) {
                    flag = true;
                }
                pq.poll();
                q.poll();
                ++answer;
            }
            
            if(flag) {
                break;
            }
        }
        
        return answer;
    }
}

class Node {
    private int priority;
    private int seq;
    
    public Node(int priority, int seq) {
        this.priority = priority;
        this.seq = seq;
    }
    
    public int getPriority() {
        return this.priority;
    }
    
    public int getSeq() {
        return this.seq;
    }
}