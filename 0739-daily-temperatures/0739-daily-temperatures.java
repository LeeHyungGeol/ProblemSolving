import java.util.*;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        for (int i = temperatures.length-1; i >= 0; --i) {
            if (deque.isEmpty()) {
                deque.offerFirst(i);
                answer[i] = 0;
            } else {
                 while (!deque.isEmpty() && temperatures[i] >= temperatures[deque.peekFirst()]) {
                    deque.pollFirst();
                }

                if (deque.isEmpty()) {
                    answer[i] = 0;
                } else {
                    answer[i] = deque.peekFirst() - i;
                }

                deque.offerFirst(i);
            }
        }

        return answer;
    }
}