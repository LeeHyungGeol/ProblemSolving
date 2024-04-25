// 효율적으로 약수의 개수 구하기
// https://chwan.tistory.com/entry/Java-%EC%95%BD%EC%88%98%EC%9D%98-%EA%B0%9C%EC%88%98-%EA%B5%AC%ED%95%98%EA%B8%B0

import java.util.stream.IntStream;

class Solution {
    public int solution(int number, int limit, int power) {
        return IntStream.rangeClosed(1,number).map(n->{
            int cnt = 0;
            for(int i = 1; i*i <= n; ++i) {
                if(i*i == n) ++cnt;
                else if (n%i==0) cnt+=2;
            }
            return cnt > limit ? power : cnt;
        }).sum();
    }
}