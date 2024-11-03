import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Integer>> graph; 
    private static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        for (int i = 0; i < n; ++i) {
            dfsAll(i, n, wires);
        }
        
        return answer;
    }
    
    private void dfsAll(int removeIndex, int n, int[][] wires) {
        boolean[] visited = new boolean[n];
        
        graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; ++i) {
            if (i == removeIndex) continue;
            graph.get(wires[i][0]-1).add(wires[i][1]-1);
            graph.get(wires[i][1]-1).add(wires[i][0]-1);
        }
        
        int cnt = dfs(1, visited);
        
        int diff = Math.abs(cnt - (n - cnt));
        answer = Math.min(answer, diff);
    }
    
    private int dfs(int start, boolean[] visited) {
        int cnt = 1;
        visited[start] = true;
        
        for (int i = 0; i < graph.get(start).size(); ++i) {
            int next = graph.get(start).get(i);
            if (visited[next]) continue;
            cnt += dfs(next, visited);
        }
        
        return cnt;
    }
}