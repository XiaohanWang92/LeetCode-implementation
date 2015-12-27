public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> sr = new ArrayList<>();
        if(nums.length==0)  return sr;
        if(nums.length==1){
            sr.add(Integer.toString(nums[0]));
            return sr;
        }
        int id=0;
        while(id<nums.length){
            int i=id;
            while((i+1)<nums.length&&(nums[i]+1)==nums[i+1]){
                i++;
            }//use while, not if!
            //use local variable i, not id!
            if(id==i){
                sr.add(Integer.toString(nums[id]));
            }
            else{
                sr.add(Integer.toString(nums[id])+"->"+Integer.toString(nums[i]));
            }
            id=i+1;
        }
        return sr;
    }
}