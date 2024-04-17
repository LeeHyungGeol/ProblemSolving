class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcdFor(n,m);
        return new int[]{gcd, n*m/gcd};
    }
    
    private int gcdRec(int a, int b) {
        if (a%b == 0)
            return b;
        return gcdRec(b, a%b);
    }
    
    private int gcdFor(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(a,b); ++i) {
            if (a%i==0 && b%i==0) {
                gcd = i;
            }
        }
        return gcd;
    }
}