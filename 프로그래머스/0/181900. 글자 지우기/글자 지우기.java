import java.lang.StringBuilder;
import java.util.Arrays;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder(my_string);
        for (int i : indices) answer.setCharAt(i, ' ');
        return answer.toString().replace(" ", "");
    }
}