import java.util.*;

class Solution {
    private static int MaxScore = 0;
    private static int[] Answer = new int[11];
    private static int[] Apeach = new int[11];
    private static int[] Ryan = new int[11];
    
    
    public int[] solution(int n, int[] info) {
        Apeach = info;
        
        dfs(0, 0, n);
        
        return MaxScore == 0 ? new int[]{-1} : Answer;
    }
    
    private void dfs(int start, int count, int size) {
        if (count == size) {
            int diff = getDiff();
            
            if (diff > MaxScore) {
                MaxScore = diff;
                Answer = Ryan.clone();
            } else if (MaxScore == diff) {
                for (int i = 10; i >= 0; --i) {
                    if (Answer[i] < Ryan[i]) {
                        Answer = Ryan.clone();
                        break;
                    }
                    if (Ryan[i] < Answer[i]) {
                        return;
                    }
                }
            }
            
            return;
        }
        
        for (int i = start; i < 11; ++i) {
            ++Ryan[i];
            dfs(i, count+1, size);
            --Ryan[i];
        }
    }
    
    private int getDiff() {
        int ryanScore = 0, apeachScore = 0;
        
        for (int i = 0; i < 11; ++i) {
            if (Ryan[i] == 0 && Apeach[i] == 0) continue;
            if (Ryan[i] > Apeach[i]) {
                ryanScore += 10-i;
            } else {
                apeachScore += 10-i;
            }
        }
        
        return ryanScore - apeachScore < 0 ? 0 : ryanScore - apeachScore;
    }
}