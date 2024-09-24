class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (true) {
            if(s.equals("1")) {
                break;
            }
            
            int before = s.length();
            s = s.replace("0","");
            int zeroCnt = before - s.length();
            s = Integer.toBinaryString(s.length()).toString();
            answer[1] += zeroCnt;
            answer[0]++;
        }
        
        return answer;
    }
}