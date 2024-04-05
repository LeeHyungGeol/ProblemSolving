import java.util.stream.Collectors;

class Solution {
    public String solution(String rsp) {
        return rsp.chars().mapToObj(i->i=='2' ? "0" : i=='5' ? "2":"5").collect(Collectors.joining());
    }
}