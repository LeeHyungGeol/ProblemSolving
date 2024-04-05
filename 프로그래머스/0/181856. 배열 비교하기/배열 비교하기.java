import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        // if (arr1.length != arr2.length) {
        //     return arr1.length > arr2.length ? 1 : -1;
        // } else {
        //     int sum1 = Arrays.stream(arr1).sum(); 
        //     int sum2 = Arrays.stream(arr2).sum();
        //     return sum1 == sum2 ? 0 : sum1 > sum2 ? 1 : -1;
        // }
        
        int answer = Integer.compare(arr1.length, arr2.length);

        if(answer == 0) {
            answer = Integer.compare(IntStream.of(arr1).sum(), IntStream.of(arr2).sum());
        }

        return answer;
    }
}