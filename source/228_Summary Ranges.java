public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summaryRangeList = new ArrayList<>();
        if(nums.length == 0)  return summaryRangeList;
        if(nums.length == 1) {
            summaryRangeList.add(Integer.toString(nums[0]));
            return summaryRangeList;
        }
        int id = 0;
        while(id < nums.length) {
            int i = id;
            while((i + 1) < nums.length && (nums[i] + 1) == nums[i + 1]) {
                i++;
            }
            if(id == i) {
                summaryRangeList.add(Integer.toString(nums[id]));
            } else {
                summaryRangeList.add(Integer.toString(nums[id]) + "->" + Integer.toString(nums[i]));
            }
            id = i + 1;
        }
        return summaryRangeList;
    }
}
