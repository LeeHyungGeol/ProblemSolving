class Solution {
    public int solution(String s) {
        char x = ' ';
        int countX = 0, countOthers = 0, answer = 0;
        
        for (char c : s.toCharArray()) {
            if (x == ' ') x=c;
            if (x==c) ++countX;
            else ++countOthers;
            if (countX == countOthers) {
                ++answer;
                x = ' ';
                countX = 0; 
                countOthers = 0;
            } 
        }
        if (countX != 0) ++answer;
        
        return answer;
    }
}