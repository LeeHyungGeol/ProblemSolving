public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();

        if(p.length()> s.length()) {
            return answer;
        }

        Map<Character, Integer> pattern = new HashMap<>();
        for(char c : p.toCharArray()){
            pattern.put(c, pattern.getOrDefault(c, 0) + 1);
        }
        int counter = pattern.size(), left = 0, right = 0;
        
        while(right < s.length()){
            char c = s.charAt(right);
            if(pattern.containsKey(c)){
                pattern.put(c, pattern.get(c)-1);
                if (pattern.get(c) == 0) {
                    --counter;
                }
            }
            ++right;
            
            while(counter == 0){
                char tempc = s.charAt(left);
                if(pattern.containsKey(tempc)){
                    pattern.put(tempc, pattern.get(tempc) + 1);
                    if(pattern.get(tempc) > 0){
                        ++counter;
                    }
                }
                if(right-left == p.length()){
                    answer.add(left);
                }
                ++left;
            }
        }

        return answer;
    }
}