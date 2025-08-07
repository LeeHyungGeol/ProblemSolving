import java.util.*;

class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private List<List<int[]>> Graph;
    
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dists = new int[n+1];
        Arrays.fill(dists, INF);

        Graph = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            Graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int c = time[2];
            Graph.get(u).add(new int[]{v, c});
        }

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        pq.offer(new int[]{0,k});
        dists[k] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0], node = cur[1];
            if (dist > dists[node]) continue;

            for (int[] edge : Graph.get(node)) {
                int next = edge[0], w = edge[1];
                int nd = dist + w;
                if (nd < dists[next]) {
                    dists[next] = nd;
                    pq.offer(new int[]{nd, next});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; ++i) {
            if (dists[i] == INF) return -1;
            answer = Math.max(answer, dists[i]);
        }
        return answer;
    }
}