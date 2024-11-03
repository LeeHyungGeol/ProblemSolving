import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }
        
        Collections.sort(list, new Comparator<String>(){ 
            public int compare(String a, String b) {
                return Integer.parseInt(b + a) - Integer.parseInt(a + b); 
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String number : list) {
            sb.append(number);
        }
        
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}