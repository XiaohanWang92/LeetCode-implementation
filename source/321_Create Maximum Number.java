public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        
        // determine number picking from nums1
        // if k is more than nums2 size, then it must pick something from nums1
        // the maximum pick num from nums1 is also detrmined by size of nums1 and k
        for(int pickNum = Math.max(k - nums2.length, 0); pickNum <= Math.min(nums1.length, k); pickNum++) {
            
            // get max number from one array
            int[] maxNumber1 = getMaxNumber(nums1, pickNum);
            int[] maxNumber2 = getMaxNumber(nums2, k - pickNum);
            int[] currentRes = merge(maxNumber1, maxNumber2, k);
            if(isLarger(currentRes, 0, result, 0)) {
                result = currentRes;
            }
        }
        return result;
    }
    
    private int[] getMaxNumber(int[] arr, int size) {
        int[] result = new int[size];
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            
            // if next number is bigger and we have enough number left in arr, 
            // we decrease index to indicate that we discard our selection to seek for a bigger number
            // have enough number condition: not-decided number in result (size - index, including number in index position) is less then arr's remaining part (arr.length - i)
            while(index > 0 && (size - index < arr.length - i) && result[index - 1] < arr[i]) {
                index--;
            }
            if(index < size) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }
    
    private int[] merge(int[] arr1, int[] arr2, int k) {
        int[] result = new int[k];
        int pos1 = 0, pos2 = 0;
        for(int i = 0; i < k; i++) {
            
            // check for current position i to decide put which number in arr1 or arr2
            // if arr1 and arr2 sizes are not equal and have part of same numbers
            // because relative order has to be preserved, we intend to put large size arr's element into result ASAP
            // so we can consider large size arr trailing elements into comparing with small size arr ASAP
            result[i] = isLarger(arr1, pos1, arr2, pos2) ? arr1[pos1++] : arr2[pos2++];
        }
        return result;
    }
    
    private boolean isLarger(int[] arr1, int pos1, int[] arr2, int pos2) {
        
        // run test case:
        // [3, 3, 4] [3, 3] need to put arr1 two 3 ASAP so 4 can be put into result at first place available
        // [3, 3, 2] [3, 3] trailing 2 should be put in result last
        // [3, 2, 4] [3, 2] same with test case 1
        // [3, 4, 3] [3, 4, 3] need to put arr1 and arr2's first 3 ASAP so two 4 can be placed into result
        while(pos1 < arr1.length && pos2 < arr2.length && arr1[pos1] == arr2[pos2]) {
            pos1 += 1;
            pos2 += 1;
        }
        if(pos2 == arr2.length) return true;
        if(pos1 == arr1.length) return false;
        if(arr1[pos1] > arr2[pos2]) return true;
        else    return false;
    }
}
