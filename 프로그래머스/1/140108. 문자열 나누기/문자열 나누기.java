import java.util.*;

class Solution {
    public int solution(String s) {
        List<String> answer = new ArrayList<>();
        String splitStr = "";
        char x = ' ';
        int countX = 0, countOthers = 0;
        
        for (char c : s.toCharArray()) {
            if (x==c || splitStr.isEmpty()) {
                x = c;
                ++countX;
                splitStr += c;
                continue;
            }
            splitStr += c;
            ++countOthers;
            if (x != c && countX == countOthers) {
                answer.add(splitStr);
                splitStr = "";
                countX = 0; 
                countOthers = 0; 
            } 
        }
        if (!splitStr.isEmpty()) answer.add(splitStr);
        
        return answer.size();
    }
}