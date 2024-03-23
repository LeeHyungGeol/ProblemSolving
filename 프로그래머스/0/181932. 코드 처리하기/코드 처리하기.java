class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for(int i = 0; i < code.length(); ++i) {
            String c = String.valueOf(code.charAt(i));
            if (mode == 0) {
                if (c.equals("1")) {
                    mode = 1;
                } else {
                    answer += i % 2 == 0 ? c : "";
                }
            } else {
                if (c.equals("1")) {
                    mode = 0;
                } else {
                    answer += i % 2 == 0 ? "" : c;
                }
            }
        }
        return answer.isEmpty() ? "EMPTY" : answer;
    }
}