class Solution {
    public int solution(String binomial) {
        String[] s = binomial.split(" ");
        return s[1].equals("+") ? Integer.parseInt(s[0])+Integer.parseInt(s[2]) : s[1].equals("-") ? Integer.parseInt(s[0])-Integer.parseInt(s[2]) : Integer.parseInt(s[0])*Integer.parseInt(s[2]);
    }
}