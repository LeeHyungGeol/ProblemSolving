import java.util.*;

class Solution {
    class StageInfo implements Comparable<StageInfo> {
        int index;
        double failure;
        
        public StageInfo(int index, double failure) {
            this.index = index;
            this.failure = failure;
        }
        
        @Override
        public int compareTo(StageInfo other) {
            if (this.failure == other.failure) {
                return this.index - other.index;
            }
            return Double.compare(other.failure, this.failure);
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] completed = new int[N+2];
        
        for (int player : stages) {
            ++completed[player];
        }
        
        int reached = stages.length;
        double[] failure = new double[N+1];
        for (int i = 1; i < N+1; ++i) {
            reached -= completed[i-1];
            if (reached == 0) {
                failure[i] = 0;
            } else {
                failure[i] = (double)completed[i]/reached;
            }
        }
        
        StageInfo[] infos = new StageInfo[N];
        for (int i = 1; i < N+1; ++i) {
            infos[i-1] = new StageInfo(i, failure[i]);
        }
        
        Arrays.sort(infos);
        
        int[] answer = new int[N];
        for (int i = 0; i < N; ++i) {
            answer[i] = infos[i].index;
        }
        
        return answer;
    }
}