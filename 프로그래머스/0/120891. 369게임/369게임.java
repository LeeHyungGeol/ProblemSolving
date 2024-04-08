class Solution {
    public int solution(int order) {
        return (int) String.valueOf(order).chars().filter(i -> (i-48)%3==0 && (i-48) != 0).count();
    }
}