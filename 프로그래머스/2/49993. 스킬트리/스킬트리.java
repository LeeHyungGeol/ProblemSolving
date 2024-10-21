import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skillTree : skill_trees) {
            int skillIndex = 0;
            boolean flag = true;
            
            for (char c : skillTree.toCharArray()) {
                int index = skill.indexOf(c);
                if (index == -1) {
                    continue;
                } else if (index == skillIndex) {
                    ++skillIndex;
                } else {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                ++answer;
            }
        }
        
        
        return answer;
    }
}