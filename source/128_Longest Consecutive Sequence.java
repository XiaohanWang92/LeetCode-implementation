public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        if(nums.length == 1)    return 1;
        HashMap<Integer, Integer> boundary = new HashMap<>();
        int max = 0;
        for(int n : nums) {
            if(boundary.containsKey(n)) continue;
            int leftSequenceSize, rightSequenceSize;
            if(boundary.containsKey(n - 1))
                leftSequenceSize = boundary.get(n - 1);
            else
                leftSequenceSize = 0;
            if(boundary.containsKey(n + 1))
                rightSequenceSize = boundary.get(n + 1);
            else
                rightSequenceSize = 0;
            int newSize = leftSequenceSize + rightSequenceSize + 1;
            
            // n can be possible new boundary
            boundary.put(n, newSize);
            
            // Update new left boundary
            boundary.put(n - leftSequenceSize, newSize);
            
            // Update new right boundary
            boundary.put(n + rightSequenceSize, newSize);
            max = Math.max(newSize, max);
        }
        return max;
    }
}
