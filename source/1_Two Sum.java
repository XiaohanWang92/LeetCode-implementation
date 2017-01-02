public class Solution {

    class Pair {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        if(nums == null || nums.length < 2)   return results;
        Pair[] pair = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++) {
            pair[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pair, new Comparator<Pair>() {

            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.val - p2.val;
            }
        });
        int i = 0, j = nums.length - 1;
        while(i < j) {
            if((pair[i].val + pair[j].val) == target) {
                results[0] = Math.min(pair[i].index, pair[j].index);
                results[1] = Math.max(pair[i].index, pair[j].index);
                return results;
            } else if((pair[i].val + pair[j].val) > target) {
                j--;
            } else {
                i++;
            }
        }
        return results;
    }
}

// other Solution
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
    int len = nums.length;
    for(int i = 0; i < len; i++) {
        if(tracker.containsKey(nums[i])) {
            int left = tracker.get(nums[i]);
            return new int[] {left, i};
        } else {
            tracker.put(target - nums[i], i);
        }
    }
    return new int[2];
}