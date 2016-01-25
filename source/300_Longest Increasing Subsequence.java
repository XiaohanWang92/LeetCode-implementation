public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null)  return 0;
        if(nums.length<=1)  return nums.length;
        //dp[j] means LIS from 0 to j
        int[] dp = new int[nums.length];
        for(int i=0; i<dp.length; i++)
            dp[i] = 1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res=0;
        for(int c : dp)
            res = Math.max(res, c);
        return res;
    }
}
