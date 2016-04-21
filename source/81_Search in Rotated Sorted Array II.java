public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return false;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] == nums[hi])
                hi--;
            else if(nums[mid] == nums[lo])
                lo++;
            else if(nums[lo] <= target && target < nums[mid]) //1
                hi = mid - 1;
            else if(nums[mid] < target && target <= nums[hi]) //2
                lo = mid + 1;
            else if(nums[lo] > nums[mid]) // case 2 is false, so target in this range
                hi = mid - 1;
            else // case A[mid] > A[end] and case 1 is false, similar to above
                lo = mid + 1;
        }
        return false;
    }
}
