import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        // return IntStream.range(0, numbers.length).map(i-> direction.equals("right") ? numbers[(numbers.length-1+i)%numbers.length] : numbers[(i+1)%numbers.length]).toArray();
        
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        if (direction.equals("right")) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        } else {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}