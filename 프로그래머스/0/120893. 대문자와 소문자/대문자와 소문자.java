import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        return my_string.chars().mapToObj(c -> String.valueOf((char) (Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c)))).collect(Collectors.joining());
    }
}