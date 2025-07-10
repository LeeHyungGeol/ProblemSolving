class Solution {
       public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for(int n : nums) {
                set.add(n);
            }

            int answer = 0;
            for(int n : set) {
                if(!set.contains(n - 1)) {  
                    int count = n + 1;
                    while(set.contains(count)) {
                        ++count;
                    }
                    answer = Math.max(answer, count-n);
                }
            }
            
            return answer;
        }
}