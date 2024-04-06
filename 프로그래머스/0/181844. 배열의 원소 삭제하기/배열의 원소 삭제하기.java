import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        // Set<Integer> deleteSet = Arrays.stream(delete_list).boxed().collect(Collectors.toSet());
        // return Arrays.stream(arr).filter(i->!deleteSet.contains(i)).toArray();
        
        return IntStream.of(arr).filter(i -> !IntStream.of(delete_list).anyMatch(s -> s == i)).toArray();

    }
}