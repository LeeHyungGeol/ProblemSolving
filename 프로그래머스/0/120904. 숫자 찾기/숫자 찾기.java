class Solution {
    public int solution(int num, int k) {
        // return String.valueOf(num).indexOf(""+k) > -1 ? String.valueOf(num).indexOf(""+k)+1 : -1;
        return ("-"+num).indexOf(""+k);
    }
}