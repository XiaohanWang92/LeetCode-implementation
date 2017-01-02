public class Solution {
    private int[] nums;
    private Random r;

    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    public int pick(int target) {
        int index = -1, targetNum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                targetNum++;
                if(r.nextInt(targetNum) == 0) {
                    index = i;
                }
            } else {
                continue;
            }
            // interesting: without eles will TLE
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
 