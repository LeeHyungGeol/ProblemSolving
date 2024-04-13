class Solution {
    public int solution(String s) {
        String[] dict = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for (int i = 0; i < dict.length; ++i) {
            s = s.replace(dict[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}