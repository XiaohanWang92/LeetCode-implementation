public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums==null || nums.length==0)    return res;
        
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid = (high-low)/2+low;
            if(nums[mid]==target){
                res[0] = mid;
                high = mid-1;
            }else if(nums[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        
        if(res[0]==-1)
            return res;
        
        low = res[0];
        high=nums.length-1;
        while(low<=high){
            int mid = (high-low)/2+low;
            if(nums[mid]==target){
                res[1] = mid;
                low = mid+1;
            }else if(nums[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return res;
    }
}
