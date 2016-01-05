public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null||nums.length<2)   return;
        int len = nums.length;
        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, len);
        int stride = 0;
        int mid = (len%2==1)?len/2:len/2-1;
        for(int i=0;i<=mid;i++){
            nums[stride] = copy[mid-i];
            if(stride+1<len){
                nums[stride+1] = copy [len-1-i];
            }
            stride = stride+2;
        }
    }
}
