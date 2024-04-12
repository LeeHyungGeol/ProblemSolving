import java.util.*;

class Solution {
    public int solution(int a, int b) {
        b/= getGCD(a,b);
        
        // while(b != 1) {
        //     if (b%2==0) b/=2;
        //     else if (b%5==0) b/=5;
        //     else return 2;
        // }
        // return 1;
        
        
        int cnt = 0;
        for (int i = 2; i<=b; ++i) {
            while (b%i==0) {
                b/=i;
                if (i!=2 && i!=5) ++cnt;
            }
        }
        if (cnt == 0) return 1;
        return 2;
    }
    
    public int getGCD(int a, int b) {
        int gcd = 0;
        for (int i = 1; i <= a && i <= b; ++i) {
            if (a%i==0 && b%i==0) gcd = i;
        }
        return gcd;
    }
}