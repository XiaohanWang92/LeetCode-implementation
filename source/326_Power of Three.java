public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 1) return false;
        if(n == 1)    return true;
        int tmp = n;
        while(tmp > 1) {
            if(tmp % 3 != 0)  return false;
            tmp /= 3;
        }
        return true;
    }
}
