import java.util.*;

class Solution {
    Set<Integer> answer = new TreeSet<>();
    
    public int[] solution(int[] numbers) {
        comb(numbers, new int[2], 0,2,0);
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    public void comb(int[] numbers, int[] selected, int cnt, int limit, int startIndex) {
        if (cnt == limit) {
            answer.add(Arrays.stream(selected).sum());
            return;
        }
        for (int i = startIndex; i < numbers.length; ++i) {
            selected[cnt] = numbers[i];
            comb(numbers, selected, cnt+1, limit, i+1);
        }
    }
}