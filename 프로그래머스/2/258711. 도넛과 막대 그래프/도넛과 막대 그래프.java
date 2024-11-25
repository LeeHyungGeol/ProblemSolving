import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        int addedNode = -1;
        int doughnut = 0;
        int stick = 0;
        int eight = 0;

        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }

        for (int node : out.keySet()) {
            if (out.get(node) > 1) { 
                if (!in.containsKey(node)) {
                    addedNode = node;
                } else {
                    ++eight;
                }
            }
        }

        for (int node : in.keySet()) {
            if (!out.containsKey(node)) {
                ++stick;
            }
        }
        
        doughnut = out.get(addedNode) - stick - eight; 
        
        return new int[]{addedNode, doughnut, stick, eight};
    }
}