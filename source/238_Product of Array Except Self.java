public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length<=1)  return nums;
        int leftMultiple=1, rightMultiple=1;
        int[] outPut = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            outPut[i]=leftMultiple;
            leftMultiple *= nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            outPut[i] *= rightMultiple;
            rightMultiple *= nums[i];
        }
        return outPut;
    }
}
