public class Solution {
    public int rob(int[] nums) {
        int rob=0;
        int norob=0;
        for(int i=0;i<nums.length;i++){
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

