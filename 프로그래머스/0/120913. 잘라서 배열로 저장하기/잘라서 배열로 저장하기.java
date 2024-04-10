import java.util.stream.IntStream;

class Solution {
    public String[] solution(String myStr, int n) {
        return IntStream.iterate(0, i->i<myStr.length(), i->i+n).mapToObj(i-> i+n > myStr.length() ? myStr.substring(i) : myStr.substring(i,i+n)).toArray(String[]::new);
    }
}