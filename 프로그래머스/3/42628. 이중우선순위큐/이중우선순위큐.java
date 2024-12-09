import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });

        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int value = Integer.parseInt(split[1]);
            
            if (command.equals("I")) {
                min.offer(value);
                max.offer(value);
            } else {
                if (!max.isEmpty() && value == -1) {
                    max.remove(min.poll());
                }
                else if (!min.isEmpty() && value == 1) {
                    min.remove(max.poll());
                }
            }
        }

        if (max.isEmpty() && min.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{max.poll(), min.poll()};
    }
}