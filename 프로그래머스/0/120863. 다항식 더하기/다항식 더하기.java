class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int a = 0, b = 0;

        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) 
                a += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            else if (!s.equals("+"))
                b += Integer.parseInt(s);
        }
        
        if (a==0)
            answer += b;
        else if (a==1 && b==0)
            answer += "x";
        else if (a==1 && b > 0)
            answer += "x + "+b;
        else if (a > 0 && b==0)
            answer += a+"x";
        else
            answer += a+"x + "+b;
        return answer;
    }
}