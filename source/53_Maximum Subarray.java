public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length == 0)
            return 0;
            
        int max = nums[0], currMax = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            currMax = Math.max(nums[i], currMax+nums[i]);
            max = Math.max(currMax, max);
        }
        
        return max;
    }
}
