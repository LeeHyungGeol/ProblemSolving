class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int[] numbers, int index, int total, int target) {
        if(index == numbers.length) {
            if(total == target) {
                ++answer;
            }
            return;
        }
        
        dfs(numbers, index + 1, total + numbers[index], target);
        dfs(numbers, index + 1, total - numbers[index], target);
    }
}