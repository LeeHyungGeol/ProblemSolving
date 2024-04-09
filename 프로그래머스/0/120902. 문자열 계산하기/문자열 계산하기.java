class Solution {
    public int solution(String my_string) {
        String[] myString = my_string.split(" ");
        int answer = Integer.parseInt(myString[0]);
        String op = myString[1];
        
        for (int i = 2; i < myString.length; ++i) {
            if (i % 2 == 0)
                answer = op.equals("+") ? answer+Integer.parseInt(myString[i]) : answer-Integer.parseInt(myString[i]); 
            else 
                op = myString[i];
        }
        return answer;
    }
}