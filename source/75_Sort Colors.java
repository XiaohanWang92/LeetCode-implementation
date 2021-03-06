public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)    return;
        int l = 0;
        int r = nums.length - 1;
        for(int i = 0; i <= r; i++) {
            if(nums[i] == 0) {
                swap(nums, i, l);
                l++;
            }
            else if(nums[i] == 2) {
                swap(nums, i, r);

                // Need decrement for checking the swap element's color
                i--;
                r--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
