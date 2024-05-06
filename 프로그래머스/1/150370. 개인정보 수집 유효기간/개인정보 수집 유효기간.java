import java.time.LocalDateTime;
import java.util.*;

// 모든 달은 28일까지 있다고 가정하였으므로 LocalDateTime 없이도 1달을 28일로 계산하여 날짜 계산을 할 수 있다.
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        LocalDateTime now = getDate(today.split("\\."));
        Map<String, Integer> map = new HashMap<>();
        
        for (String term : terms) {
            String[] tmp = term.split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        
        for (int i = 0; i < privacies.length; ++i) {
            String[] dateAndTerm = privacies[i].split(" ");
            String term = dateAndTerm[1];
            LocalDateTime date = getDate(dateAndTerm[0].split("\\."));
            
            if (now.isAfter(date.plusMonths(map.get(term)).minusDays(1))) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private LocalDateTime getDate(String[] date) {
        return LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]),0,0);
    }
}