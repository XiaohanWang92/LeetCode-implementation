public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)    return 0;
        int robFirst = nums[0] + rob(nums, 2, nums.length-2);
        int norobFirst = rob(nums, 1, nums.length-1);
        return Math.max(robFirst, norobFirst);
        }
    private int rob(int[] nums, int from, int end) {
        if(from > end)  return 0;
        int rob=0;
        int norob=0;
        for(int i=from;i<=end;i++){
            //not rob current means robber can choose robbed previous or not
            int norobCurr=Math.max(norob,rob);
            //rob current house means robber hasn't robbed the previous 'current' house
            int robCurr=nums[i]+norob;
            //update
            rob=robCurr;
            norob=norobCurr;
        }
        //finally norob and rob stand for the respective max gain of not robbing/robbing last house
        return Math.max(norob,rob);
    }
}
