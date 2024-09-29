import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] newElements = new int[elements.length * 2];
        
        for (int i = 0; i < elements.length; ++i) {
            newElements[i] = newElements[elements.length+i] = elements[i];
        }
        
        for (int i = 1; i <= elements.length; ++i) {
            for (int j = 0; j < elements.length; ++j) {
                set.add(Arrays.stream(newElements, j, j+i).sum());
            }
        }
        
        return set.size();
    }
}