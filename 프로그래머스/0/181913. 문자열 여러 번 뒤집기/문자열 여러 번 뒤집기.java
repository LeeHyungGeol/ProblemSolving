import java.lang.StringBuilder;

class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int[] q : queries) {
            StringBuilder sb = new StringBuilder(my_string.substring(q[0], q[1]+1));
            my_string = my_string.substring(0, q[0]) + sb.reverse().toString() + my_string.substring(q[1]+1); 
        }
        return my_string;
    }
}