public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)    return 0;
        int water = 0, i = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(i < height.length) {
            if(stack.size() == 0 || height[stack.peek()] >= height[i]) {
                stack.push(i);
                i++;
            } else {
                int bottom = stack.pop();
                int currentWater = 0;
                //             |
                //          ___|
                // bottom  |
                //       __| i
                if(stack.size() == 0) {
                    currentWater = 0;
                } else {
                    int leftIndex = stack.peek(), rightIndex = i;
                    currentWater = (Math.min(height[leftIndex], height[rightIndex]) - height[bottom]) * (rightIndex - leftIndex - 1);
                }
                water += currentWater;
            }
        }
        return water;
    }
}
