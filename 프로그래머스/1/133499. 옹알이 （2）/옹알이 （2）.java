import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        List<String> list = new ArrayList<>(Arrays.asList("aya", "ye", "woo", "ma"));      
        int answer = 0;
        
        // for (String b : babbling) {
        //     String tmp = "", same = "";
        //     for (char c : b.toCharArray()) {
        //         tmp += c;
        //         if (list.contains(tmp) && !same.equals(tmp)) {
        //             same = tmp;
        //             tmp = "";
        //         }
        //     }
        //     if (tmp.isEmpty()) ++answer;
        // }
        
        for(String str:babbling){
            if(str.contains("ayaaya") || str.contains("yeye") || str.contains("woowoo") || str.contains("mama"))
                continue;
            if(str.replace("aya", "1").replace("ye", "1").replace("woo", "1").replace("ma", "1").replace("1", "").length() == 0)
                answer++;
        }
        return answer;
    }
}