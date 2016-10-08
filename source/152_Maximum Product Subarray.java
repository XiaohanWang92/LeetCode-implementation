public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int maxPrevious = nums[0];
        int minPrevious = nums[0];
        int globalMax = nums[0];
        int maxCurrent, minCurrent;
        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(Math.max(maxPrevious * nums[i], minPrevious * nums[i]), nums[i]);
            minCurrent = Math.min(Math.min(maxPrevious * nums[i], minPrevious * nums[i]), nums[i]);
            globalMax = Math.max(globalMax, maxCurrent);
            maxPrevious = maxCurrent;
            minPrevious = minCurrent;
        }
        return globalMax;
    }
}
