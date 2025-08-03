import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
			return List.of(0);
		}
		if (n == 2) {
			return List.of(0, 1);
		}

		int[] degree = new int[n];
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

		for (int[] edge : edges) {
			degree[edge[0]]++;
			degree[edge[1]]++;
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (degree[i] == 1) {
				leaves.add(i);
			}
		}

		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int leaf : leaves) {
				for (int neighbor : graph.get(leaf)) {
					degree[neighbor]--;
					if (degree[neighbor] == 1) {
						newLeaves.add(neighbor);
					}
				}
			}
			leaves = newLeaves;
		}

		return leaves;
    }
}