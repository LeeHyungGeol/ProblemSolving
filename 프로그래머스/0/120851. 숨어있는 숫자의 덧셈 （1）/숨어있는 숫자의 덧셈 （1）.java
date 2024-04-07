import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        // return Arrays.stream(my_string.replaceAll("[a-z|A-Z]","").split("")).mapToInt(Integer::parseInt).sum();
    
        return my_string.chars().filter(Character::isDigit).map(i->i-48).sum();
    }
}