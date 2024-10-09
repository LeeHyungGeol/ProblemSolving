import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        private String element;
        private int count;

        public Node(String element, int count) {
            this.element = element;
            this.count = count;
        }
        
        public int convertToInt() {
            return Integer.parseInt(this.element);
        }

        @Override
        public int compareTo(Node other) {
            // count 값이 큰 것이 우선순위가 높음
            return Integer.compare(other.count, this.count);
        }
    }
    
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String number : s.split("[{},]+")) {
            if (!number.isEmpty()) {
                map.put(number, map.getOrDefault(number, 0)+1);
            }
        }
        
        for (String element : map.keySet()) {
            pq.add(new Node(element, map.get(element)));
        }
        
        while(!pq.isEmpty()) {
            answer.add(pq.poll().convertToInt());
        }
        
        return answer;
    }
}