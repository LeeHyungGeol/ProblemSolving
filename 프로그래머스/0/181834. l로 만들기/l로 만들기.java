import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        // return Arrays.stream(myString.split("")).map(s->s.compareTo("l") > 0 ? s : "l").collect(Collectors.joining());
        
        return myString.replaceAll("[^l-z]", "l");
    }
}