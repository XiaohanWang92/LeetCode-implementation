public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> hashset = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(hashset.contains(nums[i]))   hashset.remove(nums[i]);
            else    hashset.add(nums[i]);
        }
        Object[] res=hashset.toArray();
        return (int)res[0];
    }
}
/*
using XOR is the best solution? no, binary serch is O(nlgn)
*/
public class Solution {
    public int singleNumber(int[] arr) {
        Arrays.sort(arr);
        int N = arr.length, lo = 0, hi = N-1;
        while(lo < hi-1) { // if lo==hi-1, lo must be the unique number because lo is always an even index following the code below
            int mid = lo + ((hi-lo)>>>1);
            if(mid%2==0) { // mid is an even index
                if(arr[mid]==arr[mid-1]) hi = mid-2; // unique number must be before mid-1
                else lo = mid; // unique number must not be before mid
            }
            else {
                if(arr[mid]==arr[mid-1]) lo = mid+1; // unique number must be after mid
                else hi = mid-1; // unique number must not be after mid
            }
        }
        return arr[lo]; // since lo is guaranteed to be even, it must be the unique index when while loop ends  
    }
}
