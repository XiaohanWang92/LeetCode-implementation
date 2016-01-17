public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0)    return;
        int k=-1;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]<nums[i+1])
                k=i;
        }
        if(k==-1){
            Arrays.sort(nums);
            return;
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
        return;
    }
}
