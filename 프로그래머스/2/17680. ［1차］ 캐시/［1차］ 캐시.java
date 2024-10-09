import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new LinkedList<>();
        
        for (int i = 0; i < cities.length; ++i) {
            String city = cities[i].toLowerCase();
            int index = list.indexOf(city);
            
            if (index != -1) {
                answer += 1;
                list.remove(index);
                list.add(city);
            } else {
                if (!list.isEmpty() && list.size() >= cacheSize) {
                    list.remove(0);
                }
                if (cacheSize != 0) {
                    list.add(city);                     
                }
                answer += 5;
            }
        }
        
        return answer;
    }
}