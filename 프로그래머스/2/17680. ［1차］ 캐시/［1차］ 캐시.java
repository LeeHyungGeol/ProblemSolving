import java.util.*;

class Solution {
    private List<String> cache = new LinkedList<>();
    private int answer = 0;
    
    public int solution(int cacheSize, String[] cities) {        
        for (String city : cities) {
            String c = city.toLowerCase();
            
            if (isCacheHit(c)) {
                cacheHit(c);
            } else {
                cacheMiss(c, cacheSize);
            }
        }
        
        return answer;
    }
    
    private void cacheHit(String city) {
        String removed = cache.remove(cache.indexOf(city));
        cache.add(removed);
        ++answer;
    }
    
    private void cacheMiss(String city, int cacheSize) {
        if (!cache.isEmpty() && cache.size() >= cacheSize) {
            cache.remove(0);
        }
        if (cacheSize > 0) {
            cache.add(city);            
        }
        answer += 5;
    }
    
    private boolean isCacheHit(String city) {
        return cache.contains(city);
    }
}
