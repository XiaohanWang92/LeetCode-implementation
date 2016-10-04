public class Solution {

    // You need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        for(int i = 0; i < 32; i++) {
            if(1 == (n & 1))
                counter++;
            n = n >>> 1;
        }
        return counter;
    }
}
