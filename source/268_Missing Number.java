public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        for(int i = 0; i <= nums.length; i++) {
            result ^= i;
        }
        return result;
    }
}
