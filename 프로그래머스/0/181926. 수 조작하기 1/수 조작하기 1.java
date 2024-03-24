class Solution {
    public int solution(int n, String control) {
        return control.chars().reduce(n, (a,b) -> a + (b == 'w' ? 1 : b == 's' ? -1 : b == 'd' ? 10 : -10));
    }
}