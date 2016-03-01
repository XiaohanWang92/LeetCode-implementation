public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums == null || nums.length ==0 || target < nums[0] || target > nums[nums.length-1])
            return res;
        if(nums[0] == target && nums[nums.length-1] == target){
            res[0] = 0;
            res[1] = nums.length-1;
            return res;
        }
        int start = -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int m = lo + (hi - lo)/2;
            if(nums[m] == target){
                start = m;
                hi = m - 1;
            }else if(nums[m] < target)
                lo = m + 1;
            else
                hi = m - 1;
        }
        lo = 0;
        hi = nums.length - 1;
        int end = -1;
        while(lo <= hi){
            int m = lo + (hi - lo)/2;
            if(nums[m] == target){
                end = m;
                lo = m + 1;
            }else if(nums[m] < target)
                lo = m + 1;
            else
                hi = m - 1;
        }
        res[0] = start;
        res[1] = end;
        return res;
    }
}
