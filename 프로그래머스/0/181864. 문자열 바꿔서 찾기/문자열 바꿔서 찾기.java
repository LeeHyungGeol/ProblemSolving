import java.util.stream.Collectors;

class Solution {
    public int solution(String myString, String pat) {
        return myString.contains(pat.chars().mapToObj(c->(char)c=='A' ? "B":"A").collect(Collectors.joining())) ? 1:0;
    }
}