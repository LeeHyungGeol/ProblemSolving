class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                getConnectedComponents(visited, i, computers);
                ++answer;
            }
        }
        
        return answer;
    }
    
    private int getConnectedComponents(boolean[] visited, int now, int[][] computers) {
        visited[now] = true;
        int nodes = 1;
        
        for (int next = 0; next < computers[now].length; ++next) {
            if (now == next) continue;
            if (computers[now][next] == 1 && !visited[next]) {
                nodes += getConnectedComponents(visited, next, computers);
            }
        }
        
        return nodes;
    }
}