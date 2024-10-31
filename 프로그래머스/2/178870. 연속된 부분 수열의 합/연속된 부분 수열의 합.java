// 투 포인터

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0, sum = 0, size = sequence.length, N = sequence.length;
        int[] answer = new int[2];
        
        for (right = 0; right < N; ++right) {
            sum += sequence[right];
            
            while (right < N && sum > k) {
                sum -= sequence[left];
                ++left;
            }
            
            if (sum == k) {
                if (size > right - left) {
                    size = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        
        
        return answer;
    }
}