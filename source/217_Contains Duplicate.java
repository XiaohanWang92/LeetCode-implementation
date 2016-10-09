public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1)  return false;
        Set<Integer> s =new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!s.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
