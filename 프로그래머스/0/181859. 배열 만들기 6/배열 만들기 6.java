import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> answer = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (answer.isEmpty()) answer.push(arr[i]);
            else if (!answer.isEmpty() && answer.peek()==arr[i]) answer.pop();
            else if (!answer.isEmpty() && answer.peek()!=arr[i]) answer.push(arr[i]);
        }
        return answer.isEmpty() ? new int[]{-1} : answer.stream().mapToInt(i->i).toArray();
    }
}