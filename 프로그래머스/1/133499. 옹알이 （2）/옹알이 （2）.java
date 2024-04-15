import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        List<String> list = new ArrayList<>(Arrays.asList("aya", "ye", "woo", "ma"));      
        int answer = 0;
        
        for (String b : babbling) {
            String tmp = "", same = "";
            for (char c : b.toCharArray()) {
                tmp += c;
                if (list.contains(tmp) && !same.equals(tmp)) {
                    same = tmp;
                    tmp = "";
                }
            }
            if (tmp.isEmpty()) ++answer;
        }
        return answer;
    }
}