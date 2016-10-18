public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length < 3)   return results;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;//skip same
            int low = i + 1, high = nums.length - 1;
            int target = 0 - nums[i];
            while(low < high) {
                if(nums[low] + nums[high] == target) {
                    results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] == nums[low + 1])  low++;//skip
                    while(low < high && nums[high] == nums[high - 1]) high--;//skip
                    low++;//skip last same one {-9,-9,2,2,7,7}
                    high--;//low=2, nums[2]==nums[3], so low->3, and line 15 makes low->4
                } else if (target<nums[low]+nums[high]) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return results;
    }
}
