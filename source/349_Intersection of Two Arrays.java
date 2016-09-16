public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null ||
           nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> results = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                results.add(i);
            }
        }
        int[] resultsArr = new int[results.size()];
        int index = 0;
        for (int i : results) {
            resultsArr[index] = i;
            index++;
        }
        return resultsArr;
    }
}
