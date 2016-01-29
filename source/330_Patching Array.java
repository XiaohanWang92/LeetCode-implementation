public class Solution {
    public int minPatches(int[] nums, int n) {
        int index = 0, count=0;
        long cover = 1;
        while(cover <= n){
            if(nums!=null && index < nums.length && nums[index] <= cover){
                cover += nums[index++];
            }
            else{
                cover <<= 1;//patch number with value of cover
                count++;
            }
        }
        return count;
    }
}
