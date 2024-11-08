import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[col-1] == b[col-1]) {
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(a[col-1], b[col-1]);
            }
        });
        
        
        answer += sumI(data, row_begin);
        
        for (int i = row_begin+1; i <= row_end; ++i) {
            answer ^= sumI(data, i);
        }
        
        return answer;
    }
    
    private int sumI (int[][] data, int index) {
        int result = 0;
        
        for (int n : data[index-1]) {
            result += (n % index);
        }
        
        return result;
    }
}