class Solution {
    public int maximumCount(int[] nums) {
        return Math.max(nums.length - upperBound(nums, 0), lowerBound(nums, 0));
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length-1, mid = 0, index = arr.length;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                index = mid;
            }
        }

        return index;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length-1, mid = 0, index = arr.length;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                index = mid;
            }
        }

        return index;
    }
}