class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long delivery = 0;
        long pickup = 0;
        
        for (int i = n-1; i >= 0; --i) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                delivery += deliveries[i];
                pickup += pickups[i];
                
                while(delivery > 0 || pickup > 0) {
                    delivery -= cap;
                    pickup -= cap;
                    answer += (i+1) * 2;
                }
            }
        }
        
        return answer;
    }
}