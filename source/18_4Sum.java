/*
use 3sum to help 4sum, a little bit slower (beat around 80% vs beat around 99%), but I am certain mine is more readable and implementable during interview
*/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4)
            return res;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len-3; i++){
            if(i > 0 && nums[i-1] == nums[i])//skip
                continue;
            threeSum(nums, res, target - nums[i], i);
        }
        return res;
    }
    private void threeSum(int[] nums, List<List<Integer>> res, int target, int pos){
        int len = nums.length;
        for(int idx = pos+1; idx < len-2; idx++){
            if(idx > pos+1 && nums[idx-1] == nums[idx])//skip
                continue;
            int lo = idx + 1, hi = len - 1;
            while(lo < hi){
                int sum = nums[idx] + nums[lo] + nums[hi];
                if(sum == target){
                    List<Integer> l = new ArrayList<Integer>(Arrays.asList(nums[pos], nums[idx], nums[lo], nums[hi]));
                    // if(!res.contains(l)) no need
                    res.add(l);
                    while(lo < hi && nums[lo+1] == nums[lo])    lo++;//skip
                    while(lo < hi && nums[hi-1] == nums[hi])    hi--;//skip
                    lo++;//skip last one
                    hi--;//skip last one
                }else if(sum > target)
                    hi--;
                else
                    lo++;
            }
        }
    }
}
/*
Below is a great solution from thread:
https://leetcode.com/discuss/69517/7ms-java-code-win-over-100%25
*/


public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /*
     * Find all possible distinguished three numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, the three numbers))
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
            int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
            int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }
}
