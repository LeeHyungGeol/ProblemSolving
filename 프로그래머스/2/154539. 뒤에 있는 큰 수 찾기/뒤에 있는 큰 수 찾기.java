// n 이 1_000_000 이기 때문에, O(n^2) 인 완전 탐색으로는 시간 초과가 발생한다.
// Stack 을 이용해야 한다.
import java.util.*;

class Solution {
    
    static class Node {
        private int index;
        private int value;
        
        public Node (int index, int value) {
            this.index = index;
            this.value = value;
        }
        
        public int getIndex() {
            return this.index;
        }
        
        public int getValue() {
            return this.value;
        }
    }
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Node> stack = new Stack<>();
        
        for (int i = 0; i < numbers.length; ++i) {
            int number = numbers[i];
            while (!stack.isEmpty() && number > stack.peek().getValue()) {
                Node node = stack.pop();
                answer[node.getIndex()] = number;
            }
            stack.push(new Node(i, number));   
        }
        
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            answer[node.getIndex()] = -1;
        }
        
        return answer;
    }
}