public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0)    return 0;
        int i=0, j=i, min = Integer.MAX_VALUE, sum = 0;
        
        for( ; i<nums.length; i++){
            sum += nums[i];
            while(sum >= s){
                min = Math.min(min, i-j+1);
                sum -= nums[j];
                j++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
