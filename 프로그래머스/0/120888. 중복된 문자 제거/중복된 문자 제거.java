import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        // return my_string.chars().distinct().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
         return my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
    }
}