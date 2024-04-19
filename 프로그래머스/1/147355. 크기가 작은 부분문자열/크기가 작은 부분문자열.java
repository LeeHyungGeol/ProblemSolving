import java.util.stream.IntStream;

class Solution {
    public int solution(String t, String p) {
        return (int) IntStream.rangeClosed(0,t.length()-p.length()).mapToObj(i->t.substring(i,i+p.length())).filter(s->Long.parseLong(s) <= Long.parseLong(p)).count();
    }
}