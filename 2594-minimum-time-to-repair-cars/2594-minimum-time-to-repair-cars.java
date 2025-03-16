import java.util.*;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long)Arrays.stream(ranks).min().getAsInt() * cars * cars;
        
        while (left < right) {
            long mid = (left + right) / 2;

            if (canAllCarsBeFixed(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canAllCarsBeFixed(int[] ranks, int cars, long minutes) {
        long totalMinutes = 0;

        for (int rank : ranks) {
            totalMinutes += Math.sqrt(minutes / rank);
        }

        return totalMinutes >= cars;
    }
}