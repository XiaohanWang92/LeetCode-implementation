public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null)    return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, subset, nums, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int pos){
        if(pos==nums.length){
            res.add(new ArrayList(subset));
            return;
        }
        //not choose current element
        backtrack(res, subset, nums, pos+1);
        //choose current element
        subset.add(nums[pos]);
        backtrack(res, subset, nums, pos+1);
        subset.remove(subset.size()-1);
    }
}
