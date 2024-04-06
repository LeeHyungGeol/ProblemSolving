import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        // Map<Integer, Integer> dict = getDict(rank);
        // int[] arr = IntStream.range(0, rank.length).filter(i->attendance[i]).map(i->rank[i]).sorted().limit(3).map(dict::get).toArray();
        // return 10000*arr[0]+100*arr[1]+arr[2];
        
         return IntStream.range(0, rank.length)
                .filter(i -> attendance[i])
                .boxed()
                .sorted(Comparator.comparing(i -> rank[i]))
                .limit(3L)
                .reduce((current, next) -> current * 100 + next)
                .get();
    }
    
    public Map getDict(int[] rank) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i=0; i<rank.length; ++i) dict.put(rank[i], i);
        return dict;
    }
}