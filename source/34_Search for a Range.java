public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length-1])
            return result;
        if(nums[0] == target && nums[nums.length - 1] == target) {
            result[0] = 0;
            result[1] = nums.length - 1;
            return result;
        }
        int start = -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if(nums[m] == target) {
                start = m;

                // continue to search
                hi = m - 1;
            } else if(nums[m] < target)
                lo = m + 1;
            else
                hi = m - 1;
        }
        lo = 0;
        hi = nums.length - 1;
        int end = -1;
        while(lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if(nums[m] == target) {
                end = m;

                // continue to search
                lo = m + 1;
            }else if(nums[m] < target)
                lo = m + 1;
            else
                hi = m - 1;
        }
        result[0] = start;
        result[1] = end;
        return result;
    }
}
