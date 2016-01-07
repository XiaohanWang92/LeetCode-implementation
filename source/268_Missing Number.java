public class Solution {
    public int missingNumber(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            res = res^nums[i];
        }
        for(int i=0;i<nums.length+1;i++){
            res = res^i;
        }
        return res;
    }
}
