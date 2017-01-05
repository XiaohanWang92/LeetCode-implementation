public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)    return false;
        int tmp = n;
        while(tmp > 2) {
            if(tmp % 2 == 1) {
                return false;
            }
            tmp = tmp / 2;
        }
        return true;
    }
}
