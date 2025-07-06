class Solution {
    private static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        backtracking(dungeons, new boolean[dungeons.length], 0, k);
        
        return answer;
    }
    
    private void backtracking(int[][] dungeons, boolean[] visited, int count, int k) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; ++i) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                backtracking(dungeons, visited, count+1, k-dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}