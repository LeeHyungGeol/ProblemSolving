import java.util.stream.IntStream;

class Solution {
    public int[] solution(String[] strlist) {
        return IntStream.range(0, strlist.length).map(i->strlist[i].length()).toArray();
    }
}