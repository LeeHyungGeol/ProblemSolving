// 5개를 한묶음으로 묶어서 피로도를 계산한 후, worst 피로도를 best 인 dia 로 해결해야 한다.

import java.util.*;

class Solution {
    static class TiredNess {
        private int diaTired;
        private int ironTired;
        private int stoneTired;
        
        public TiredNess(int diaTired, int ironTired, int stoneTired) {
            this.diaTired = diaTired;
            this.ironTired = ironTired;
            this.stoneTired = stoneTired;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = Arrays.stream(picks).sum();
        List<TiredNess> list = new ArrayList<>();
        int[][] tiredBoard = new int[][]{{1,1,1}, {5,1,1}, {25,5,1}};
        
        for (int i = 0; i < minerals.length; i+=5) {
            if (totalPicks == 0) break;
            
            int diaTired = 0, ironTired = 0, stoneTired = 0;
            for (int j = i; j < i+5; ++j) {
                if (j >= minerals.length) break;
                
                int tiredBoardColumn = minerals[j].equals("diamond") ? 0 : minerals[j].equals("iron") ? 1 : 2;
                diaTired += tiredBoard[0][tiredBoardColumn];
                ironTired += tiredBoard[1][tiredBoardColumn];
                stoneTired += tiredBoard[2][tiredBoardColumn];
            }
            
            list.add(new TiredNess(diaTired, ironTired, stoneTired));
            --totalPicks;
        }
        
        Collections.sort(list, (a,b) -> b.stoneTired - a.stoneTired);
        
        for (TiredNess tiredNess : list) {
            if (picks[0] > 0) {
                answer += tiredNess.diaTired;
                --picks[0];
            } else if (picks[1] > 0) {
                answer += tiredNess.ironTired;
                --picks[1];
            } else {
                answer += tiredNess.stoneTired;
                --picks[2];
            }
        }
        
        return answer;
    }
    
}