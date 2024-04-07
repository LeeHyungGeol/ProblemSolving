import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (String str : s.split(" ")) {
            if (str.equals("Z")) stack.pop();
            else stack.push(Integer.parseInt(str));
        }
        
        for (int i :stack) answer += i;
        
        return answer;
    }
}