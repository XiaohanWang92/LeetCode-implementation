public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}

// other method
public class Solution {
    public int findDuplicate(int[] nums) {

        // time complexity: O(nlgn)
        // initial search range: 1- n
        int left = 1, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            // if number of elements is larger than its range
            // the duplicate must come from this range
            if (count > mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == left) {
                candidate++;
            }
        }
        return candidate > 1 ? left : right;
    }
}
