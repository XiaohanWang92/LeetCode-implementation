public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1)  return nums[0];
        int curMax = nums[0], curMin = nums[0], res = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                curMax = Math.max(curMax*nums[i], nums[i]);
                curMin = Math.min(curMin*nums[i], nums[i]);
            }else if(nums[i]==0){
                curMax = 0;
                curMin = 0;
            }
            else{
                int tmp = curMax;
                curMax = Math.max(curMin*nums[i], nums[i]);
                curMin = Math.min(tmp*nums[i], nums[i]);
            }
            res = Math.max(res, curMax);
        }
        return res;
    }
}
