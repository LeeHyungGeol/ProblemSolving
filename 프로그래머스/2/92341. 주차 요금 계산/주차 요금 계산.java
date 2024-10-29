import java.util.*;

class Solution {
    public static int END_TIME = 1439;
    public static int BASE_TIME = 0;
    public static int BASE_FEE = 0;
    public static int UNIT_TIME = 0;
    public static int UNIT_FEE = 0;
    
    public List<Integer> solution(int[] fees, String[] records) {
        BASE_TIME = fees[0];
        BASE_FEE = fees[1];
        UNIT_TIME = fees[2];
        UNIT_FEE = fees[3];
        Map<String, Integer> in = new TreeMap<>();
        Map<String, Integer> inOut = new TreeMap<>();
        
        for (String record : records) {
            String[] temp = record.split(" ");
            int time = timeToInt(temp[0]);
            String carNumber = temp[1];
            String inOrOut = temp[2];
            
            if (inOrOut.equals("IN")) {
                in.put(carNumber, time);
            } else {
                int startTime = in.get(carNumber);
                in.remove(carNumber);
                
                if (inOut.containsKey(carNumber)) {
                    int currentTotalTime = inOut.get(carNumber);
                    inOut.replace(carNumber, currentTotalTime + (time-startTime));
                } else {
                    inOut.put(carNumber, time-startTime);
                }
            }
        }
        
        for (String carNumber : in.keySet()) {
            int startTime = in.get(carNumber);
            if (inOut.containsKey(carNumber)) {
                int currentTotalTime = inOut.get(carNumber);
                inOut.replace(carNumber, currentTotalTime + (END_TIME-startTime));
            } else {
                inOut.put(carNumber, END_TIME-startTime);
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for (String carNumber : inOut.keySet()) {
            answer.add(getFee(inOut.get(carNumber)));
        }
        
        return answer;
    }
    
    private int timeToInt(String time) {
        String[] temp = time.split(":");
        return (Integer.parseInt(temp[0]) * 60) + Integer.parseInt(temp[1]);
    }
    
    private int getFee(int time) {
        if (time > BASE_TIME) {
            return (int) (BASE_FEE + (Math.ceil((double)(time-BASE_TIME)/UNIT_TIME) * UNIT_FEE));
        }
        return BASE_FEE;
    }
}