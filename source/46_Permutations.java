public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0)  return res;
        permute(nums, res, 0);
        return res;
    }
    private void permute(int[] nums, List<List<Integer>> res, int pos){
        if(pos == nums.length-1){
            List<Integer> l = new ArrayList<>();
            for(int i : nums)
                l.add(i);
            res.add(l);
        }
        for(int i = pos; i<nums.length; i++){
            swap(nums, pos, i);
            permute(nums, res, pos+1);
            swap(nums, i, pos);
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
