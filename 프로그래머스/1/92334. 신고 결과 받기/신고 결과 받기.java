import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> reportedCounts = new HashMap<>();
        Map<String, Set<String>> reportedInfo = new HashMap<>();
        
        for (String r : report) {
            String[] split = r.split(" ");
            String reporter = split[0];
            String reported = split[1];
            
            boolean flag = true;
            
            if (reportedInfo.containsKey(reporter) && reportedInfo.get(reporter).contains(reported)) {
                flag = false;
            }
            reportedInfo.computeIfAbsent(reporter, key -> new HashSet<>()).add(reported);                
            
            if (flag) {
                reportedCounts.put(reported, reportedCounts.getOrDefault(reported, 0) + 1);
            }
        }
        
        int index = 0;
        for (String reporter : id_list) {
            int count = 0;
            if (reportedInfo.containsKey(reporter)) {                
                for (String reported : reportedInfo.get(reporter)) {
                    if (reportedCounts.get(reported) >= k) {
                        ++count;
                    }
                }
            }
            answer[index++] = count;
        }
        
        return answer;
    }
}