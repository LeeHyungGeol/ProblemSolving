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
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Node> stack = new Stack<>();
        
        for (int i = 0; i < numbers.length; ++i) {
            int n = numbers[i];
            while (!stack.isEmpty() && n > stack.peek().getValue()) {
                Node node = stack.pop();
                answer[node.getIndex()] = n;
            }
            stack.push(new Node(n, i));
        }
        
        for (int i = 0; i < answer.length; ++i) {
            if (answer[i] == 0)
                answer[i] = -1;
        }
        
        return answer;
    }
}