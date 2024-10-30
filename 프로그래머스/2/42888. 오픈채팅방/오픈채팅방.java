import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for (String r : record) {
            String[] temp = r.split(" ");
            String command = temp[0];
            String userId = temp[1];
            
            if (!command.equals("Leave")) {
                String nickname = temp[2];
        
                if (command.equals("Change")) {
                    map.replace(userId, nickname);
                } else {
                    map.put(userId, nickname);
                }
            }
        }
        
        for (String r : record) {
            String[] temp = r.split(" ");
            String command = temp[0];
            String userId = temp[1];
            
            if (command.equals("Enter")) {
                answer.add(map.get(userId) + "님이 들어왔습니다.");
            }
            if (command.equals("Leave")) {
                answer.add(map.get(userId) + "님이 나갔습니다.");
            }
        }
        
        
        return answer;
    }
}