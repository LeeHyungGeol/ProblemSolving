class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (char c : s.toCharArray()) {
            int tmp = 0, cnt = 0;
            String jump = "";
            while(cnt < index) {
                ++tmp;
                jump = String.valueOf((char)((c-'a'+tmp)%26 + 'a'));
                if (!skip.contains(jump)) ++cnt;
            }
            answer += jump;
        }
        
        return answer;
    }
}