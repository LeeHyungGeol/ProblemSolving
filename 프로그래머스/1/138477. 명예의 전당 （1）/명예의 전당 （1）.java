import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] answer = new int[score.length];
        
        for(int i = 0; i < score.length; ++i) {
            list.add(score[i]);
            Collections.sort(list);
            
            if(list.size() > k) list.removeFirst();
            answer[i] = list.getFirst();
        }
        return answer;
    }
}