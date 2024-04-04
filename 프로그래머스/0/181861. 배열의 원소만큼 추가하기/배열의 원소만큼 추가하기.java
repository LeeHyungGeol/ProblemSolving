import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
       String answer = "";
        for(int n: arr) answer += (String.valueOf(n)+",").repeat(n);
        return Arrays.stream(answer.split(",")).mapToInt(Integer::parseInt).toArray(); 
    }
}