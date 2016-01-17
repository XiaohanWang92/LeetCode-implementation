/*TLE*/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> check = new HashSet<>(); // check duplicate
        if(nums.length==0)  return res;
        permute(nums, res, 0, check);
        return res;
    }
    private void permute(int[] nums, List<List<Integer>> res, int pos, Set<String> check){
        if(pos == nums.length-1){
            List<Integer> l = new ArrayList<>();
            for(int i : nums)
                l.add(i);
            if(check.add(l.toString()))
                res.add(l);
        }
        for(int i = pos; i<nums.length; i++){
            swap(nums, pos, i);
            permute(nums, res, pos+1, check);
            swap(nums, i, pos);
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
/right one/
public class Solution {
    public boolean nextPermutation(int[] nums) {
        int k=-1;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]<nums[i+1])
                k=i;
        }
        if(k==-1){
            Arrays.sort(nums);
            return false;
        }
        int r=k+1;
        for(int j=k+1; j<nums.length; j++){
            if(nums[j]>nums[k])
                r=j;
        }
        int tmp = nums[k];
        nums[k] = nums[r];
        nums[r] = tmp;
        Arrays.sort(nums, k+1, nums.length);
        return true;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null || nums.length==0)    return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ascending = new ArrayList<>();
        for(int num : nums){
            ascending.add(num);
        }
        res.add(ascending);
        while(nextPermutation(nums)){
            List<Integer> l = new ArrayList<>();
            for(int num : nums)
                l.add(num);
            res.add(l);
        }
        return res;
    }
}
