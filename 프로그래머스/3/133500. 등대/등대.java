import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> Graph = new ArrayList<ArrayList<Integer>>();
    private static int Answer = 0;
    
    public int solution(int n, int[][] lighthouse) {
        int[] visited = new int[n+1];
        
        for (int i = 0; i <= n; ++i) {
            Graph.add(new ArrayList<>());
        }
        
        for (int[] light : lighthouse) {
            int a = light[0];
            int b = light[1];
            Graph.get(a).add(b);
            Graph.get(b).add(a);
        }
        
        dfs(visited, 1);
        
        for (int i = 0; i < visited.length; ++i) {
            if (visited[i] == 2) {
                ++Answer;
            }
        }
        
        return Answer;
    }
    
    private void dfs(int[] visited, int current) {
        visited[current] = 1;
        
        for (int next : Graph.get(current)) {
            if (visited[next] == 0) {
                dfs(visited, next);
                if (visited[next] == 1) {
                    visited[current] = 2;
                }
            }
        }
    }
}