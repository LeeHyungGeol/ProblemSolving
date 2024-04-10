class Solution {
    public int solution(int n) {
        // return n % Math.sqrt(n) == 0 ? 1 : 2
        // return Math.sqrt(n) % 1 == 0 ? 1 : 2;
        return Math.pow((int)Math.sqrt(n), 2) == n ? 1 : 2;
    }
}