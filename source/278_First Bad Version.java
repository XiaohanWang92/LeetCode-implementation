/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right) {
            int id = left + (right - left) / 2;
            if(!isBadVersion(id)) {
                left = id + 1;
            } else {
                right = id;
            }
        }
        return left;
    }
}
