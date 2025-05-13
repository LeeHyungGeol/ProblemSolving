import java.util.*;

class Solution {
    private Map<String, String> ID = new HashMap<>();
    
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        for (String r : record) {
            String[] split = r.split(" ");
            
            if ("Enter".equals(split[0]) || "Change".equals(split[0])) {
                ID.put(split[1], split[2]);
            }
        }
        
        for (String r : record) {
            String[] split = r.split(" ");
            
            if ("Enter".equals(split[0])) {
                answer.add(ID.get(split[1]) + "님이 들어왔습니다.");
            } 
            if("Leave".equals(split[0])) {
                answer.add(ID.get(split[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}