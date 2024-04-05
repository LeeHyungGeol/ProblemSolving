class Solution {
    public int solution(String num_str) {
        return num_str.chars().map(i->i-'0').sum();
    }
}