public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)  return 0;
        if(heights.length == 1) return heights[0];
        Deque<Integer> indexStack = new LinkedList<>();
        int i = 0, maxArea = 0, n = heights.length;

        // try test case: 7,4,5,6,1
        while(i < n) {
            if(indexStack.size() == 0 || heights[indexStack.peek()] <= heights[i]) {
                indexStack.push(i);
                i++;
            } else {
                int index = indexStack.pop();
                int width = indexStack.size() == 0 ? i : i - 1 - indexStack.peek();
                maxArea = Math.max(maxArea, heights[index] * width);
            }
        }

        // try test case: 1, 1, 1, 1, 1
        while(indexStack.size() != 0) {
            int index = indexStack.pop();
            int width = indexStack.size() == 0 ? n : n - 1 - indexStack.peek();
            maxArea = Math.max(maxArea, heights[index] * width);
        }
        return maxArea;
    }
}
