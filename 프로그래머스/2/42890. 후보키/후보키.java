import java.util.*;

class Solution {
    private static int ColumnSize = 0;
    private static int RowSize = 0;
    private static ArrayList<HashSet<Integer>> Candidates = new ArrayList<HashSet<Integer>>();
    
    public int solution(String[][] relation) {
        RowSize = relation.length;
        ColumnSize = relation[0].length;
        
        for (int i = 0; i < ColumnSize; ++i) {
            boolean[] visited = new boolean[ColumnSize];
            dfs(relation, visited, 0, i+1);
        }
        
        return Candidates.size();
    }
    
    private void dfs(String[][] relation, boolean[] visited, int count, int size) {
        if (count == size) {
            HashSet<Integer> columnIndexes = getColumnIndexes(visited);
            
            if (!isUnique(relation, columnIndexes)) {
                return;
            }
            
            if (!isMinimal(columnIndexes)) {
                return;
            }
            
            Candidates.add(columnIndexes);
            return;
        }
        
        for (int i = 0; i < ColumnSize; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(relation, visited, count+1, size);
            visited[i] = false;
        }
    }
    
    private boolean isUnique(String[][] relation, Set<Integer> columnIndexes) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < RowSize; ++i) {
            StringBuilder sb = new StringBuilder();
            
            for (int columnIndex : columnIndexes) {
                sb.append(relation[i][columnIndex]);
            }
            
            if (list.contains(sb.toString())) {
                return false;
            } else {
                list.add(sb.toString());
            }
        }
        
        return true;
    }
    
    private boolean isMinimal(Set<Integer> columnIndexes) {
        for (Set<Integer> candidate : Candidates) {
            if (columnIndexes.containsAll(candidate)) {
                return false;
            }
        }
        
        return true;
    }
    
    private HashSet<Integer> getColumnIndexes(boolean[] visited) {
        HashSet<Integer> indexes = new HashSet<>();
        
        for (int i = 0; i < ColumnSize; ++i) {
            if (visited[i]) {
                indexes.add(i);
            }
        }
        
        return indexes;
    }
}