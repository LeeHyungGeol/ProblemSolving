class Solution {
    boolean solution(String s) {
        return s.toLowerCase().chars().filter(i -> 'p'== i).count() == s.toLowerCase().chars().filter(i -> 'y'==i).count();
    }
}