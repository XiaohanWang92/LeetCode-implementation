public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1)  return nums[0];
        int max = nums[0];
        int currentMax = nums[0];
        for(int i=1; i<nums.length; i++){
            currentMax += nums[i];
            if(currentMax < nums[i])
                currentMax = nums[i];
            if(max < currentMax)
                max = currentMax;
        }
        return max;
    }
}
