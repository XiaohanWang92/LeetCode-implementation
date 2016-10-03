public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        if(nums.length == 1)  return nums[0];
        int len = nums.length;
        int l = 0, r = len - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(mid != 0 && nums[mid] < nums[mid - 1])   return nums[mid];
            if(nums[mid] >= nums[l] && nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }
}
