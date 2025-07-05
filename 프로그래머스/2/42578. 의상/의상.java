import java.util.*;

// 옷 종류마다 안 입는 경우 1개씩 추가해서 다 곱해준 다음에 마지막에 1(다 안입는 경우) 빼주는 것

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothCounter = new HashMap<>();
        
        for (int i = 0; i < clothes.length; ++i) {
            clothCounter.put(clothes[i][1], clothCounter.getOrDefault(clothes[i][1], 0)+1);
        }
        
        for (int count : clothCounter.values()) {
            answer *= count+1;
        }
        
        return answer-1;
    }
}