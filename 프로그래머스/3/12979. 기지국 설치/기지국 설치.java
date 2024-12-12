import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 1, stationIndex = 0;
        
        while (index <= n) {
            if (stations[stationIndex]-w <= index && index <= stations[stationIndex]+w) {
                index = stations[stationIndex]+w+1;
                ++stationIndex;
                if (stationIndex == stations.length) {
                    stationIndex = stations.length-1;
                }
            } else {
                index += (2*w)+1;
                ++answer;
            }
        }
        
        return answer;
    }
}