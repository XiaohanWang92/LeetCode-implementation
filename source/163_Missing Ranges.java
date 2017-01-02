public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if(nums == null)  return new ArrayList<String>();
        if(nums.length == 0) {
            String s = lower == upper ? Integer.toString(lower) : lower + "->" + upper;
            return new ArrayList<String>(Arrays.asList(s));
        }
        List<String> results = new ArrayList<>();
        int start = nums[0] + 1;
        int end = nums[0] - 1;
        if(nums[0] > lower) {
            results.add((end == lower) ? Integer.toString(lower) : lower + "->" + end);
        }
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1)
                start = nums[i] + 1;
            else {
                end = nums[i] - 1;
                results.add((end == start) ? Integer.toString(start) : start + "->" + end);
                start = nums[i] + 1;
            }
        }
        if(nums[nums.length - 1] != upper)
            results.add((nums[nums.length - 1] + 1 == upper) ? Integer.toString(upper) : (nums[nums.length - 1] + 1) + "->" + upper);
        return results;
    }
}
