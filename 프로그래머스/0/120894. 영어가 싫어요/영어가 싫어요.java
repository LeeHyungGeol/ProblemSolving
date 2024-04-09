import java.util.*;

class Solution {
    Map<String, Integer> dict = new HashMap<>(){{
            put("zero",0);
            put("one",1);
            put("two",2);
            put("three",3);
            put("four",4);
            put("five",5);
            put("six",6);
            put("seven",7);
            put("eight",8);
            put("nine",9);
    }};
    
    public long solution(String numbers) {
        // String answer = "", tmp = "";
        // for (String n : numbers.split("")) {
        //     tmp += n;
        //     if (dict.containsKey(tmp)) {
        //         answer += dict.get(tmp);
        //         tmp = "";
        //     }
        // }
        // return Long.parseLong(answer);
        
         String[] numbers_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for (int i = 0; i < numbers_arr.length; i++) {
                numbers = numbers.replaceAll(numbers_arr[i], String.valueOf(i));
            }

            long answer = Long.parseLong(numbers);
            return answer;
    }
}