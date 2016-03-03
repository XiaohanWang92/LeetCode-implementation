public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len ; i++){
        //if current value's slot don't have a proper value in slot, we use swap to put current value to this proper slot
        //after exchange, if the new value's slot don't have proper value, do it iteratively
        //if you check if current slot contain proper value, then there may be a dead loop
        //for example [1, 1], first 1, you check is ok, 2nd 1 is not ok so you swap it to proper slot 0
        //then you still get a 1, a dead loop
            while(nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i])
                swap(nums, i, nums[i]-1);
        }
        for(int i=0; i < len; i++){
            if(nums[i] != i+1) return i+1;
        }
        return len+1;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
