public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1)
            return 1;
        if(nums.length == 2)
            return nums[0] == nums[1] ? 1 : 2;
        int size = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1])
                nums[size++] = nums[i];
        }
        return size;
    }
}
