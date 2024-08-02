// 올바른 괄호인지 판단할 때 가장 중요한 것은 "가장 최근에 나온 여는 괄호" 이다.
// 탐색을 함에 있어서 "가장 최근에 나온 여는 괄호" 에 대한 정보를 계속해서 저장

// 1. Stack을 통해서 "여는 괄호"들을 관리할 것이다.
// 2. "닫는 괄호"를 만나게 되면, Stack의 top()에 있는 "여는 괄호"를 가져오고 비교
//  2-1. stack이 비어있거나, "여는 괄호"와 "닫는 괄호" 의 쌍이 안 맞는다면 false
//  2-2. 쌍이 맞다면, stack.pop()
// 3. 모든 탐색이 끝난 후, "Stack이 비어있어야만" 올바른 문자열이다.

import java.util.*;

class Solution {
    Map<Character, Character> map;
    
    public int solution(String s) {
        int answer = 0;
        int size = s.length();
        StringBuffer sb = new StringBuffer(s);
        map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(int i = 0; i < size; ++i) {
            boolean flag = isProper(sb);
            if(flag) {
                ++answer;
            }
            sb = turn(sb, size);
        }
        return answer;
    }
    
    public StringBuffer turn(StringBuffer sb, int size) {
        return sb.append(sb.charAt(0)).deleteCharAt(0);
    }
    
    public boolean isProper(StringBuffer sb) {
        String s = sb.toString();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            
            if(c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty() || map.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}