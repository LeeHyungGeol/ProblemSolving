import java.util.*;

class Solution {
    public int solution(int[] order) {
        int count = 0;
        Queue<Integer> truck = new LinkedList<>();
        Stack<Integer> assist = new Stack<>();
        
        for (int i = 0; i < order.length; ++i) {
            assist.add(i+1);
            
            while (!assist.isEmpty()) {
                if (assist.peek() == order[count]) {
                    assist.pop();
                    truck.add(i);
                    ++count;
                } else {
                    break;
                }
            }
        }
        
        return truck.size();
    }
}