import java.util.*;
import java.util.stream.*;
import java.lang.Integer;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> numList = Arrays.stream(num_list).boxed().collect(Collectors.toList());
       numList.add(num_list[num_list.length-1] > num_list[num_list.length-2] ? num_list[num_list.length-1]-num_list[num_list.length-2] : num_list[num_list.length-1]*2);
        return numList.stream().mapToInt(i->i).toArray();
    }
}