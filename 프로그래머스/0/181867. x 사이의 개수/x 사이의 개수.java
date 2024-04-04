import java.util.Arrays;

class Solution {
    public int[] solution(String myString) {
        // return Arrays.stream(myString.split("x", myString.length())).mapToInt(str->str.length()).toArray();
        return Arrays.stream(myString.split("x", -1)).mapToInt(str->str.length()).toArray();
    }
}