public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1
            if(nums[mid] == target)
                return mid;

            // Case 2
            else if(nums[start] <= target && target < nums[mid])
                end = mid - 1;

            // Case 3
            else if(nums[mid] < target && target <= nums[end])
                start = mid + 1;

            // Case 4
            else if(nums[start] > nums[mid])
                end = mid - 1;

            // Case 5
            else
                start = mid + 1;
        }
        return -1;
    }
}
