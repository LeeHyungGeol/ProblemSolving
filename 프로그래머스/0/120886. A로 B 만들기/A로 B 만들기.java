import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] arr1 = before.toCharArray();
        char[] arr2 = after.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return new String(arr1).equals(new String(arr2)) ? 1 : 0;
    }
}