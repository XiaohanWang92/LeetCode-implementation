public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3)   return 0;
        Arrays.sort(nums);
        int count = 0;
        int low = 0;
        int high = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            low = i + 1;
            high = nums.length - 1;
            while(low < high) {
                if(nums[i] + nums[low] + nums[high] < target) {
                    count += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return count;
    }
}
