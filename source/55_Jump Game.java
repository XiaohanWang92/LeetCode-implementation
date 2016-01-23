public class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null)  return false;
        if(nums.length<=1)  return true;
        int reach = nums[0];
        for(int dist=0; dist<nums.length; dist++){
            if(dist>reach)  return false;
            reach = Math.max(reach, dist+nums[dist]);
        }
        return true;
    }
}
