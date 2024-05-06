import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = {0,3,2,1,0,1,2,3};
        char[][] type = {{'R','T'}, {'C','F'}, {'J','M'}, {'A','N'}};
        Map<Character, Integer> map = new HashMap<>() {{
            put('R',0);
            put('T',0);
            put('C',0);
            put('F',0);
            put('J',0);
            put('M',0);
            put('A',0);
            put('N',0);
        }};
        String answer = "";
        
        for (int i = 0; i < survey.length; ++i) {
            if (choices[i] < 5) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+score[choices[i]]);
            } else {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+score[choices[i]]);
            }
        }
        // if (map.get('R') >= map.get('T')) answer +="R";
        // else answer += "T";
        // if (map.get('C') >= map.get('F')) answer +="C";
        // else answer += "F";
        // if (map.get('J') >= map.get('M')) answer +="J";
        // else answer += "M";
        // if (map.get('A') >= map.get('N')) answer +="A";
        // else answer += "N";
        
        for (char[] t : type) {
            answer += map.get(t[0]) >= map.get(t[1]) ? t[0] : t[1];
        }
        
        return answer;
    }
}