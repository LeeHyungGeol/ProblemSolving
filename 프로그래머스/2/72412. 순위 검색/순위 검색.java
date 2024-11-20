import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (String i : info) {
            String[] split = i.split(" ");
            String[] langs = {split[0], "-"};
            String[] positions = {split[1], "-"};
            String[] careers = {split[2], "-"};
            String[] foods = {split[3], "-"};
            int value = Integer.parseInt(split[4]);
            
            for (String lang : langs) 
                for (String position : positions) 
                    for (String career : careers) 
                        for (String food : foods) {
                            String key = lang+position+career+food;
                            List<Integer> values = map.getOrDefault(key, new ArrayList<>());
                            values.add(value);
                            map.put(key, values);
                        }
        }
        
        for (List<Integer> values : map.values()) {
            Collections.sort(values);
        }
        
        int[] answer = new int[query.length];
        int index = 0;
        for (String q : query) {
            String[] split = q.split(" and ");
            String key = split[0]+split[1]+split[2]+(split[3].split(" "))[0];
            
            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);
                int target = Integer.parseInt((split[3].split(" "))[1]);
                
                answer[index] = list.size() - binarySearch(list, target);
            }
            index++;
        }
        
        return answer;
    }
    
    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        
        return left;
    }
}