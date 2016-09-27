public class Solution {
    int volume;
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int width = height.length - 1;
        int i = 0;
        int j = width;
        while(i < j) {
            volume = Math.max((j - i) * Math.min(height[i], height[j]), volume);
            if(height[i] < height[j]) {
                while(i + 1 <= width && height[i + 1] <= height[i]) {
                    i++;
                }
                i++;
            } else {
                while(j - 1 >= 0 && height[j - 1] <= height[j]) {
                    j--;
                }
              j--;
            }
        }
        return volume;
    }
}
