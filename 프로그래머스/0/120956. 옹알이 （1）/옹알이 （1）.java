import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        // List<String> list = new ArrayList<>(Arrays.asList("aya", "ye", "woo", "ma"));
        // int answer  = 0;
        // for (String b : babbling) {
        //     String s = "";
        //     for (char c : b.toCharArray()) {
        //         s += c;
        //         if (list.contains(s)) s = "";
        //     }
        //     if (s.isEmpty()) ++answer;
        // }
        // return answer;
        
        int answer = 0;
        
        for (String b : babbling) {
            b = b.replace("aya","1");
            b = b.replace("ye","1");
            b = b.replace("woo","1");
            b = b.replace("ma","1");
            b = b.replace("1","");
            if (b.isEmpty()) ++answer;
        }
        return answer;
    }
}