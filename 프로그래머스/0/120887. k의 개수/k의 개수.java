import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public int solution(int i, int j, int k) {
        // String str = "";
        // for (int l = i; l <= j; ++l) {
        // str += String.valueOf(l);
        // }
        // return str.length() - str.replace(k+"", "").length();
        
        return (int)IntStream.rangeClosed(i,j).filter(n->String.valueOf(n).contains(String.valueOf(k))).mapToObj(String::valueOf).collect(Collectors.joining()).chars().mapToObj(c->(char)c).filter(c -> c == (k + '0')).count();
    }
}