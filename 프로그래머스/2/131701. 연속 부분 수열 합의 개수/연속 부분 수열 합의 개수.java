// 배열의 끝을 이어붙여 원형으로 사용할 때는 배열 2개를 이어붙이는 것을 생각하자!
// % 연산도 생각하자!
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; ++i) {
            for (int j = 0; j < elements.length; ++j) {
                int sum = 0;
                for (int k = j; k < j+i; ++k) {
                    sum += elements[k%elements.length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}

// import java.util.*;
// import java.util.stream.*;

// class Solution {
//     public int solution(int[] elements) {
//         Set<Integer> set = new HashSet<>();
//         int[] newElements = new int[elements.length * 2];
        
//         for (int i = 0; i < elements.length; ++i) {
//             newElements[i] = newElements[elements.length+i] = elements[i];
//         }
        
//         for (int i = 1; i <= elements.length; ++i) {
//             for (int j = 0; j < elements.length; ++j) {
//                 set.add(Arrays.stream(newElements, j, j+i).sum());
//             }
//         }
        
//         return set.size();
//     }
// }