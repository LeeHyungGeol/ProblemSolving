import java.util.*;

class Solution {
    public String solution(String s) {        
        String[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().mapToObj(i-> i+"").toArray(String[]::new);
        return arr[0] + " " + arr[arr.length-1];
    }
}