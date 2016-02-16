public class Solution {
    public int findPeakElement(int[] num) {    
        return helper(num,0,num.length-1);
    }
    public int helper(int[] num,int start,int end){
        if(start == end){
            return start;
        }else if(start+1 == end){
            if(num[start] > num[end]) return start;
            return end;
        }else{
            int m = (start+end)/2;
            if(num[m] > num[m-1] && num[m] > num[m+1]){
                return m;
            }else if(num[m-1] > num[m] && num[m] > num[m+1]){
                return helper(num,start,m-1);
            }else{
                return helper(num,m+1,end);
            }
        }
    }
}
/******************************************************************/
/*iterative*/
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)    return 0;
        if(nums.length == 2)    return nums[0]>nums[1]?0:1;
        
        int start = 0, end = nums.length-1;
        
        while(start < end){
            int mid1 = start + (end - start)/2;
            int mid2 = mid1 + 1;
            if(nums[mid1] < nums[mid2]){
                start = mid2;
            }else{
                end = mid1;
            }
        }
        
        return start;
        
    }
}
