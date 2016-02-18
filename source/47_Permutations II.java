public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        permute(nums, 0, list, res);
        return res;
    }
    private void permute(int[] nums, int idx, List<Integer> list, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        HashSet<Integer> used = new HashSet<>();
        for(int i = idx; i < nums.length; i++){
            if(used.add(nums[i])){
                list.add(nums[i]);
                swap(nums, idx, i);
                permute(nums, idx+1, list, res);
                list.remove(list.size()-1);
                swap(nums, idx, i);
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
