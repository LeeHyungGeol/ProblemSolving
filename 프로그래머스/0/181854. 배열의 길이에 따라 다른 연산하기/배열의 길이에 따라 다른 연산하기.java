import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int n) {
        return arr.length % 2 == 1 ? IntStream.range(0, arr.length).map(i->i%2==0?arr[i]+n:arr[i]).toArray() : IntStream.range(0, arr.length).map(i->i%2==1?arr[i]+n:arr[i]).toArray(); 
    }
}