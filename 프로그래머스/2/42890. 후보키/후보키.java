import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        List<Integer> answer = new ArrayList<>();
        int n = relation.length;
        int m = relation[0].length;
        
        for(int i = 1; i < (1<<m); ++i) {
            Set<String> set = new HashSet<>();
            for(int j = 0; j < n; ++j) {
                String str = "";
                for(int k = 0; k < m; ++k) {
                    if((i & (1<<k)) > 0) {
                        str += relation[j][k];
                    }
                }
                set.add(str);         
            }
            
            if(set.size() == n && check(answer, i)) {
                answer.add(i);
            }
        }
        
        return answer.size();
    }
    
    public boolean check(List<Integer> answer, int now) {
        for(int i : answer) {
            if((i & now) == i) {
                return false;
            }
        }
        return true;
    }
}