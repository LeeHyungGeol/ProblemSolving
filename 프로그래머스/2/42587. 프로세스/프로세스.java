import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        private int weight;
        
        public Node(int weight) {
            this.weight = weight;
        }
        
        public int getWeight() {
            return this.weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(other.weight, this.weight);
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i = 0; i < priorities.length; ++i) {
            pq.add(new Node(priorities[i]));
        }
        
        while(!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; ++i) {
                if (priorities[i] == pq.peek().getWeight()) {
                    if (i == location) {
                        return answer;
                    }
                    pq.poll();
                    ++answer;
                }
            } 
        }
        
        return answer;
    }
}