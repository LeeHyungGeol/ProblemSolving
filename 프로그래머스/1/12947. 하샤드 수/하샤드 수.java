class Solution {
    public boolean solution(int x) {
        int sum = String.valueOf(x).chars().map(i->i-'0').sum();
        return x % sum == 0;
    }
}