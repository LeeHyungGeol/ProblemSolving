import java.util.*;

class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        
        int[] count1 = build(edges1, k);
        int[] count2 = build(edges2, k - 1);

        int maxCount2 = Arrays.stream(count2).max().getAsInt();

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = count1[i] + maxCount2;
        }
        return answer;
    }

    private int[] build(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = dfs(i, -1, graph, k);
        }
        return result;
    }

    private int dfs(int cur, int parent, List<List<Integer>> graph, int k) {
        if (k < 0) {
            return 0;
        }
        int result = 1;
        for (int child : graph.get(cur)) {
            if (child == parent) {
                continue;
            }
            result += dfs(child, cur, graph, k - 1);
        }
        return result;
    }
}