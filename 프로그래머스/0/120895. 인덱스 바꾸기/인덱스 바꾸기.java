import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        // StringBuffer answer = new StringBuffer(my_string);
        // char c1 = answer.charAt(num1);
        // char c2 = answer.charAt(num2);
        // answer.setCharAt(num1, c2);
        // answer.setCharAt(num2, c1);
        // return answer.toString();
        
        List<String> list = Arrays.stream(my_string.split("")).collect(Collectors.toList());

        Collections.swap(list, num1, num2);
        return String.join("", list);
    }
}