import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        private int value;
        
        public Node(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return this.value;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.value, other.value);
        }
    }
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(new Node(s));
        }
        
        while (!(pq.peek().getValue() >= K)) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            
            int first = pq.poll().getValue();
            int second = pq.poll().getValue();
            
            if (second == 0) {
                answer = -1;
                break;
            }
                        
            pq.offer(new Node(mix(first, second)));
            ++answer;
        }
        
        
        return answer;
    }
    
    private int mix(int first, int second) {
        return first + (second * 2);
    }
}