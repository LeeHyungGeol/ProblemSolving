import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(int n) {
        // return IntStream.range(0,n).mapToObj(i->i%2==0?"수":"박").collect(Collectors.joining());
        
        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }
}