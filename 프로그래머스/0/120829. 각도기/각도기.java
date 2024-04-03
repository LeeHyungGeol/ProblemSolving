class Solution {
    public int solution(int angle) {
        return angle == 180 ? 4 : 180 > angle && angle > 90 ? 3 : angle == 90 ? 2 : 1;
    }
}