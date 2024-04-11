import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.split("\\D+")).filter(s->!s.isEmpty()).mapToInt(Integer::parseInt).sum();
        
        // my_string.replaceAll("[a-zA-Z]", " ").split(" ");
        // return Arrays.stream(myString.split("[A-Z|a-z]")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();

    }
}