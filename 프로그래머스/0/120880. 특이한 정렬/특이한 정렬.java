import java.util.Arrays;

class Solution {
    public int[] solution(int[] numList, int n) {
//         int[][] arr = new int[numList.length][];
//         int[] answer = new int[numList.length];
        
//         for (int i = 0; i <numList.length; ++i) {
//             int[] tmp = {Math.abs(numList[i]-n), numList[i]};
//             arr[i] = tmp;
//         }
        
//         Arrays.sort(arr, (o1,o2)-> o1[0]==o2[0] ? o2[1]-o1[1] : o1[0]-o2[0]);
        
//         for (int i = 0; i < numList.length; ++i) {
//             answer[i] = arr[i][1];
//         }
        
//         return answer;
        
        
        return Arrays.stream(numList)
                .boxed()
                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}