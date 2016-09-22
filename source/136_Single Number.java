public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]))   set.remove(nums[i]);
            else    set.add(nums[i]);
        }
        Integer[] res=set.toArray(new Integer[1]);
        return res[0];
    }
}

/*
 * binary serch is O(nlgn)
 */
public class Solution {
    public int singleNumber(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length, lo = 0, hi = len - 1;
        while(lo < hi - 1) { // if lo == hi-1, lo must be the unique number because lo is always an even index following the code below
            int mid = lo + (hi - lo) / 2;
            if(mid % 2 == 0) { // mid is an even index
                if(arr[mid] == arr[mid - 1]) hi = mid - 2; // same pair's index is odd-even format, unique number must be before mid - 1
                else lo = mid; // two possible, mid is single number, or before single numberm same pair's index is even-odd format, so even(mid) means first number of the pair, arr[mid] != arr[mid - 1]
            } else {
                if(arr[mid] == arr[mid - 1]) lo = mid + 1; // before single number, odd-even pair appear
                else hi = mid - 1; // after single number, even-odd pair appear
            }
        }
        return arr[lo]; // since lo is guaranteed to be even (line 24, 26), it must be the unique index when while loop ends  
    }
}

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }
}
