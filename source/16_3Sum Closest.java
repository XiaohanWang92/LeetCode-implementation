public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<=2)
            return 0;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int low = i+1;
            int high = nums.length-1;
            while(low<high){
                int sum = nums[i] + nums[low] +nums[high];
                int currDiff = Math.abs(sum - target);
                if(currDiff<diff){
                    res = sum;
                    diff = currDiff;
                }
                if(sum<target)
                    low++;
                else    
                    high--;
            }
        }
        return res;
    }
}
