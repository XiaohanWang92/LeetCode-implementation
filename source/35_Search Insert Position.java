public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if(nums[m] == target)   return m;
            else if(nums[m] < target)
                lo = m + 1;
            else
                hi = m - 1;
        }
        return lo;
    }
}
