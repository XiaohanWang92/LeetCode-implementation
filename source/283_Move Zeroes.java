public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==0)  return;
        int firstZeroPos = 0;
        while(nums[firstZeroPos] != 0 && firstZeroPos < nums.length - 1)
            firstZeroPos++;
        if(firstZeroPos == nums.length - 1)
            return;
        for(int i = firstZeroPos + 1; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, firstZeroPos);
                firstZeroPos++;
            }
        }
    }

    private void swap(int[] nums, int n, int m) {
        int temp;
        temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}
