import java.util.*;

class Solution {
    static class Node {
        private int value;
        private int index;
        
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        public int getValue() {
            return this.value;
        }
        
        public int getIndex() {
            return this.index;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; ++i) {
            int price = prices[i];
            while (!stack.isEmpty() && stack.peek().getValue() > price) {
                Node node = stack.pop();
                answer[node.getIndex()] = i - node.getIndex();
            }
            stack.push(new Node(price, i));
        }
        
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            answer[node.getIndex()] = answer.length - node.getIndex() -1;
        }
        
        return answer;
    }
}