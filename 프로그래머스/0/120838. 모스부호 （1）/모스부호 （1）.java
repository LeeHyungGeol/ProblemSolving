import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String letter) {
        Map<String, String> morse = getMorse();
        return Arrays.stream(letter.split(" ")).map(morse::get).collect(Collectors.joining());
    }
    
    public Map getMorse() {
        Map<String, String> morse = new HashMap<>() {{
            put(".-", "a");
            put("-...", "b");
            put("-.-.", "c");
            put("-..", "d");
            put(".", "e");
            put("..-.", "f");
            put("--.", "g");
            put("....", "h");
            put("..", "i");
            put(".---", "j");
            put("-.-", "k");
            put(".-..", "l");
            put("--", "m");
            put("-.", "n");
            put("---", "o");
            put(".--.", "p");
            put("--.-", "q");
            put(".-.", "r");
            put("...", "s");
            put("-", "t");
            put("..-", "u");
            put("...-", "v");
            put(".--", "w");
            put("-..-", "x");
            put("-.--", "y");
            put("--..", "z");
        }};
        return morse;
    }
}