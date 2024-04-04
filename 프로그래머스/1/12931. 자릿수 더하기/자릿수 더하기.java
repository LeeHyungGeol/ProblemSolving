import java.util.*;

public class Solution {
    public int solution(int n) {
        return String.valueOf(n).chars().map(i -> i-'0').sum();
    }
}