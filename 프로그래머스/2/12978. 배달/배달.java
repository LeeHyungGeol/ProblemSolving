// 그래프 최단거리 알고리즘 문제
// 간선마다 가중치가 다르므로, 다익스트라 혹은 플로이드 워셜로 문제를 풀 수 있다.
// 노드의 개수(N)이 50개 이하이므로, 플로이드 워셜 알고리즘으로 충분히 시간 제한 없이 풀 수 있을거라고 판단하고,
// 해당 알고리즘을 적용하여 풀었다.
// (int) 1e9 대신 Integer.MAX_VALUE 를 사용하면 정수 오버플로우 문제 때문에 답이 틀릴 수 있다.


class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] dist = new int[N][N];
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i != j) {
                    dist[i][j] = (int) 1e9;
                } else {
                    dist[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < road.length; ++i) {
            int a = road[i][0]-1;
            int b = road[i][1]-1;
            int c = road[i][2];
            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);
        }
        
        for (int k = 0; k < N; ++k) {
            for (int a = 0; a < N; ++a) {
                for (int b = 0; b < N; ++b) {
                    dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                    dist[b][a] = Math.min(dist[b][a], dist[b][k] + dist[k][a]);
                }
            }
        }
        
        for (int i = 0; i < N; ++i) {
            if (dist[0][i] <= K) {
                ++answer;
            }
        }

        return answer;
    }
}