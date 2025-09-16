class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] sum = new int[n+1];
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            sum[i+1] = sum[i] + gain[i];
            answer = Math.max(answer, sum[i+1]);
        }

        return answer;
    }
}