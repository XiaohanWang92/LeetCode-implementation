public class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0)    return;
        int len = nums.length;
        k = k % len; // k may be biger than array size
        swap(nums, 0, len - 1);
        swap(nums, 0, k - 1); // k is the number(steps), when considering index, always minus 1
        swap(nums, k, len - 1);
        
    }

    private void swap(int[] nums, int s, int e) {
        while(s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
