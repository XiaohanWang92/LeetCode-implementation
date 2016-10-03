public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)  return 0;
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int id = 0; id < nums.length; id++) {
            sum += nums[id];
            if(sum == k)  maxLen = id + 1;
            else if(map.containsKey(sum - k)) {
                maxLen = (id - map.get(sum - k)) > maxLen ? (id - map.get(sum - k)) : maxLen;
            }
            if(!map.containsKey(sum))
                map.put(sum, id);
        }
        return maxLen;
    }
}
