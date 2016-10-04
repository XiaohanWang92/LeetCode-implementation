public class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;
        for(int i = 0; i < nums.length; i++) {

            // Not rob current means robber can choose robbed previous or not
            int notRobCurrent = Math.max(notRob, rob);

            // Rob current house means robber hasn't robbed the previous 'current' house
            int robCurrent = nums[i] + notRob;

            // Update
            rob = robCurrent;
            notRob = notRobCurrent;
        }

        // Finally notRob and rob stand for the respective max gain of not robbing/robbing last house
        return Math.max(notRob, rob);
    }
}
