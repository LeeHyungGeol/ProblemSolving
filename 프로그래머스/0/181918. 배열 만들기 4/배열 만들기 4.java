import java.util.Stack;

class Solution {
    public Stack<Integer> solution(int[] arr) {
        Stack<Integer> answer = new Stack<>();
        int i = 0;
        while(i < arr.length) {
            if (answer.size() == 0) {answer.push(arr[i]); ++i;}
            else {
                if(answer.peek() < arr[i]) {answer.push(arr[i]); ++i;}
                else answer.pop();
            }
        }
        return answer;
    }
}