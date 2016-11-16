public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return new int[0];
        if(k == 1)  return nums;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> indexDeque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(!indexDeque.isEmpty() && indexDeque.peekFirst() < i - k + 1) {
                indexDeque.pollFirst();
            }
            while(!indexDeque.isEmpty() && nums[i] > nums[indexDeque.peekLast()]) {
                indexDeque.pollLast();
            }
            indexDeque.offerLast(i);
            if(i - k + 1 >= 0) {
                result[i - k + 1] = nums[indexDeque.peekFirst()];
            }
        }
        return result;
    }
}
