import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public long solution(String[] strArr) {
//         Map<Integer, Long> lengthCountMap = Arrays.stream(strArr)
//                 .collect(Collectors.groupingBy(String::length, Collectors.counting()));

//         return lengthCountMap.values().stream()
//                 .max(Long::compare)
//                 .orElse(0L);
        
//        return Arrays.stream(strArr).collect(Collectors.groupingBy(String::length)).values().stream().max(Comparator.comparingInt(List::size)).orElse(Collections.emptyList()).size();

        
        Map<Integer, Integer> lengthCountMap = new HashMap<>();
        int answer = 0;

        for (String str : strArr) {
            lengthCountMap.put(str.length(), lengthCountMap.getOrDefault(str.length(), 0) + 1);
        }

        for (int count : lengthCountMap.values()) {
            answer = Math.max(answer, count);
        }

        return answer;
    }
}