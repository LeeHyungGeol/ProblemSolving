import java.util.*;

class Solution {
    private static int[] arr1 = {1, 2, 3, 4, 5};
    private static int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] counter = new int[3];
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < answers.length; ++i) {
            if (answers[i] == arr1[i%5]) ++counter[0];
            if (answers[i] == arr2[i%8]) ++counter[1];
            if (answers[i] == arr3[i%10]) ++counter[2];
        }
        
        int MAX = Math.max(counter[0], Math.max(counter[1], counter[2]));
        
        for (int i = 0; i < 3; ++i) {
            if (MAX == counter[i]) 
                answer.add(i+1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}