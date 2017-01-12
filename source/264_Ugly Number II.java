public class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1)   return 1;
        int[] u = new int[n];
        u[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int multiple2 = 2, multiple3 = 3, multiple5 = 5;
        for(int i = 1; i < n; i++) {
            u[i] = Math.min(multiple2, Math.min(multiple3, multiple5));

            // update next number in corresponding list
            if(u[i] == multiple2) {
                index2++;
                multiple2 = 2 * u[index2];
            }
            if(u[i] == multiple3) {
                index3++;
                multiple3 = 3 * u[index3];
            }
            if(u[i] == multiple5) {
                index5++;
                multiple5 = 5 * u[index5];
            }
        }
        return u[n - 1];
    }
}
