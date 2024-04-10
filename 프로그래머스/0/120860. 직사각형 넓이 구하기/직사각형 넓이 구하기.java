import java.util.Arrays;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (o1,o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        return Math.abs(dots[0][0]-dots[3][0])*Math.abs(dots[0][1]-dots[3][1]);
    }
}