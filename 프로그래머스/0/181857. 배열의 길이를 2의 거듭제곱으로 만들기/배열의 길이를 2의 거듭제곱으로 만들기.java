import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
       // int limit = (int)IntStream.rangeClosed(0,10).map(i->(int)Math.pow(2,i)-arr.length).filter(n->n>=0).min().orElse(0);
        // return IntStream.concat(Arrays.stream(arr), IntStream.range(0, limit).map(i -> 0)).toArray();
        int length = 1;

        while (length < arr.length) {
            length *= 2;
        }

        return Arrays.copyOf(arr, length);
        // Arrays.copyOf(), Arrays.copyOfRange() 의 빈부분의 배열은 모두 [0] 으로 채워진다.
    }
}