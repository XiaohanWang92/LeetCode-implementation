public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, nums.length - k, 0, nums.length - 1);
    }
    
    private int findKthSmallest(int[] nums, int k, int s, int e) {
        int pivot = nums[e];
        int i = s;
        int j = e - 1;
        while(i <= j) {
            if(nums[i] <= pivot) {
                i++;
            } else {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            }
        }
        int tmp = nums[j + 1];
        nums[j + 1] = nums[e];
        nums[e] = tmp;
        int cur = j + 1;
        if(cur == k) {
            return nums[cur];
        } else if(cur < k) {
            return findKthSmallest(nums, k, cur + 1, e);
        } else {
            return findKthSmallest(nums, k, s, cur - 1);
        }
    }
}

// Another solution
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p = randomSelect(nums, 0, n - 1, n - k + 1);//index based
        return nums[p];
    }

    private int randomSelect(int[] nums, int lo, int hi, int k) {
        java.util.Random r = new java.util.Random();
        long seed = r.nextLong();
        java.util.Random pivotGen = new java.util.Random(seed);

        // NextInt(n) generate random from 0 - n - 1, it can be offset of index lo, so we feed Random with the index range hi - lo + 1
        int pivotindex = pivotGen.nextInt(hi - lo + 1) + lo;

        // Swap pivot to hi position
        swap(nums, pivotindex, hi);
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j) {
            if (nums[i++] > pivot) swap(nums, --i, --j);
        }
        swap(nums, i, hi);

        // Count the nums that are <= pivot from lo
        int m = i - lo + 1;

        // Pivot is the one!
        if (m == k) return i;

        // Pivot is too big, so it must be on the left
        else if (m > k) return randomSelect(nums, lo, i - 1, k);

        // Pivot is too small, so it must be on the right
        else    return randomSelect(nums, i + 1, hi, k - m);
        
    }
    private void swap(int[] nums, int e, int f) {
        int tmp = nums[e];
        nums[e] = nums[f];
        nums[f] = tmp;
    }
}
