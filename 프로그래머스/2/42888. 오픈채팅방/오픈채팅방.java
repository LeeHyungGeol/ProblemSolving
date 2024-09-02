import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(String r : record) {
            String[] splits = r.split(" ");
            
            if(splits[0].equals("Enter") || splits[0].equals("Change")) {
                map.put(splits[1], splits[2]);
            }
        }
        
        for(String r : record) {
            String[] splits = r.split(" ");
            
            if(splits[0].equals("Enter")) {
                String temp = map.get(splits[1]) + "님이 들어왔습니다.";
                answer.add(temp);
            }
            else if(splits[0].equals("Leave")) {
                String temp = map.get(splits[1]) + "님이 나갔습니다.";
                answer.add(temp);
            }
        }
        
        return answer;
    }
}