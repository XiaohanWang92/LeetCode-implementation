public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null)    return new ArrayList<List<Integer>>();
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(results, subset, nums, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> subset, int[] nums, int pos) {
        if(pos == nums.length) {
            if(results.contains(subset))    return;
            results.add(new ArrayList(subset));
            return;
        }

        //not choose current element
        backtrack(results, subset, nums, pos + 1);

        //choose current element
        subset.add(nums[pos]);
        backtrack(res, subset, nums, pos + 1);
        subset.remove(subset.size() - 1);
    }
}
