public class Solution {
    public int jump(int[] A) {
        int currLong = 0, nextLong = 0, level = 0;
        for (int i = 0; i < A.length; i++) {
            if (i - 1 == currLong) {
                level++;
                currLong = nextLong;
            }
            nextLong = Math.max(nextLong, A[i] + i);
        }
        return level;
    }

    // My TLE on last test
    public int jump(int[] nums) {
        int length = nums.length;
        if(length < 2)  return 0;
        int level = 0, currentMaxDist = 0, nextMaxDist = 0, currentLevelNum = 1;
        while(currentLevelNum > 0) {
            level++;
            for(int index = 0; index <= currentMaxDist; index++) {
                nextMaxDist = Math.max(nextMaxDist, nums[index] + index);
                if(nextMaxDist >= length - 1) {
                    return level;
                }
            }
            currentLevelNum = nextMaxDist - currentMaxDist;
            currentMaxDist = nextMaxDist;
        }
        return 0;
    }
}

public class Solution {
    public int jump(int[] nums) {
        
        // border case
        if(nums == null || nums.length < 2) return 0;
        
        // initialization
        int currentIndex = 0;
        int currentReachedRegion = nums[currentIndex];
        int step = 1;
        
        // start jumping
        while(currentReachedRegion < nums.length - 1) {
            int nextIndex = currentIndex;
            int nextReachedRegion = currentReachedRegion;
            for(int i = currentIndex; i <= currentReachedRegion; i++) {
                if(i + nums[i] > nextReachedRegion) {
                    nextIndex = i;
                    nextReachedRegion = i + nums[i];
                }
            }
            currentIndex = nextIndex;
            currentReachedRegion = nextReachedRegion;
            step++;
        }
        return step;
    }
}
