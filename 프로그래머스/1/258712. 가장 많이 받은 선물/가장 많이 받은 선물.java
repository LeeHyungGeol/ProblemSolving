import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> friendIndexes = new HashMap<>();
        int[] giftDegree = new int[friends.length];
        int[][] giftGraph = new int[friends.length][friends.length];
        
        for ( int i = 0; i < friends.length; i++ ) {
            friendIndexes.put(friends[i], i);
        }
        
        for (String gift : gifts) {
            String[] giftName = gift.split(" ");
            giftDegree[friendIndexes.get(giftName[0])]++;
            giftDegree[friendIndexes.get(giftName[1])]--;
            giftGraph[friendIndexes.get(giftName[0])][friendIndexes.get(giftName[1])]++;    
        }
        
        for (int i =0; i< friends.length; ++i) {
            int count = 0;
            for (int j = 0; j< friends.length; ++j) {
                if (i == j) continue;
                    
                if (giftGraph[i][j] > giftGraph[j][i] || (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])) {
                    ++count;
                }
            }
            
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}