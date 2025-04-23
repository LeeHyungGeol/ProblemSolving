import java.util.*;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<Integer>> counter = new HashMap<>();


        for (int i = 0; i < keyName.length; ++i) {
            counter.computeIfAbsent(keyName[i], k -> new TreeSet<>()).add(convertStringTimeToInt(keyTime[i].split(":")));
        }

        Set<String> answer = new TreeSet<>();
        for (Map.Entry<String, TreeSet<Integer>> entry : counter.entrySet()) {
            List<Integer> time = new ArrayList<>(entry.getValue());
            for(int i = 2; i < time.size(); i++) {
                if((time.get(i)-time.get(i-2)) <= 60) {
                    answer.add(entry.getKey());
                    break;
                }
            }
        }

        return new ArrayList<>(answer);
    }

    private int convertStringTimeToInt(String[] time) {
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }
}