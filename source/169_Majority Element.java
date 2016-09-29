/*Boyer-Moore Majority Vote Algorithm*/
/*http://www.cs.utexas.edu/~moore/best-ideas/mjrty/*/
/*space O(1) time O(n)*/
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int vote = 1;
        for(int i = 1; i < nums.length; i++) {
            if(vote == 0) {
                vote = 1;
                candidate = nums[i];
            } else if (candidate != nums[i]) {
                vote--;
            } else {
                vote++;
            }
        }
        return candidate;
    }
}
/*general idea*/
/*
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
*/
