import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1]-b[1];
            }
        });
        
        int answer = 1;
        int end = routes[0][1];
        
        for (int[] route : routes) {
            int s = route[0];
            int e = route[1];
            if (s > end) {
                ++answer;
                end = e;
            }
        }
        
        return answer;
    }
}