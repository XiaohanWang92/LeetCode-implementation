public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0)  return 0;
        if(nums.length<3)   return nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        int size = 0;
        for(int i=0; i<nums.length; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i] , 1);
                nums[size++] = nums[i];
            }else{
                if(hm.get(nums[i])==2)
                    continue;
                else if(hm.get(nums[i])==1){
                    nums[size++] = nums[i];
                    hm.put(nums[i], 2);
                }
            }
        }
        return size;
    }
}
