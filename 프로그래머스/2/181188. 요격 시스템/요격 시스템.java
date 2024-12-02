import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        
        int end = targets[0][1];
        ++answer; 
        
        for(int[] target : targets){
            int s = target[0];
            int e = target[1];
            if(s >= end){
                end = e;
                ++answer;
            }
        }
        
        return answer;
    }
}