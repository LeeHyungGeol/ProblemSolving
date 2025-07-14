class Solution {
       public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for(int n : nums) {
                set.add(n);
            }

            int answer = 0;
            for(int n : set) {
                if(!set.contains(n - 1)) {  
                    int next = n + 1;
                    while(set.contains(next)) {
                        ++next;
                    }
                    answer = Math.max(answer, next-n);
                }
            }
            
            return answer;
        }
}