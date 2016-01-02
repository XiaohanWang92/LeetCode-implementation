public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> hashset = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(hashset.contains(nums[i]))   hashset.remove(nums[i]);
            else    hashset.add(nums[i]);
        }
        Object[] res=hashset.toArray();
        return (int)res[0];
    }
}
/*
using XOR is the best solution
*/
