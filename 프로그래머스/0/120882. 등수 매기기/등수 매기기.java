import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        List<Integer> list = new ArrayList<>();
        for(int[] s : score){
            list.add(s[0] + s[1]);
        }
        
        list.sort(Comparator.reverseOrder());

        int[] answer = new int[score.length];
        for(int i=0; i<score.length; ++i){
            answer[i] = list.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
    }
}