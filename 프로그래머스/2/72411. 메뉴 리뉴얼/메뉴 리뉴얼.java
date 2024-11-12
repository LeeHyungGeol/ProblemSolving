import java.util.*;

class Solution {
    static Map<String, Integer> counter;
    static int max = 0;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int courseSize : course) {
            counter = new HashMap<>();
            max = 0;
            
            for (String order : orders) {
                char[] sortedOrder = order.toCharArray();
                Arrays.sort(sortedOrder);
            
                dfs(sortedOrder, "", new boolean[sortedOrder.length], courseSize, 0);
            }
            
            for (String key : counter.keySet()) {                
                if (counter.get(key) > 1 && counter.get(key) == max) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
    
    private void dfs(char[] order, String newOrder, boolean[] visited, int size, int start) {
        if (newOrder.length() == size) {
            counter.put(newOrder, counter.getOrDefault(newOrder, 0) + 1);
            max = Math.max(max, counter.get(newOrder));
            return;
        }
        
        for (int i = start; i < order.length; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(order, newOrder + order[i], visited, size, i+1);
            visited[i] = false;
        }
    }
}