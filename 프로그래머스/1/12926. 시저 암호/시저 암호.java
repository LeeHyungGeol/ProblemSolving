import java.util.stream.Collectors;

class Solution {
    public String solution(String s, int n) {
        return s.chars().map(c -> {
            if (Character.isUpperCase(c)) {
                return (c-'A'+n) % 26 + 'A';
            } else if (Character.isLowerCase(c)) {
                return (c-'a'+n) % 26 + 'a';
            } else {
                return c;
            }
        }).mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
    }
}