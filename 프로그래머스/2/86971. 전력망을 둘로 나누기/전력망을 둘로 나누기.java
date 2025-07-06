import java.util.*;

class Solution {
    private static int answer = Integer.MAX_VALUE;
    private static List<List<Integer>> Graph = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        for (int remove = 0; remove < n; ++remove) {
            dfsAll(remove, n, wires);
        }
        
        return answer;
    }
    
    private void dfsAll(int remove, int n, int[][] wires) {
        Graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            Graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; ++i) {
            if (i == remove) continue;
            Graph.get(wires[i][0]-1).add(wires[i][1]-1);
            Graph.get(wires[i][1]-1).add(wires[i][0]-1);
        }
        
        boolean[] visited = new boolean[n];
        int count = countConnectedComponents(1, visited);
        int diff = Math.abs(count - (n-count));
        
        answer = Math.min(answer, diff);
    }
    
    private int countConnectedComponents(int start, boolean[] visited) {
        int count = 1;
        visited[start] = true;
        
        for (int i = 0; i < Graph.get(start).size(); ++i) {
            if (visited[Graph.get(start).get(i)]) continue;
            count += countConnectedComponents(Graph.get(start).get(i), visited);
        }
        
        return count;
    }
}