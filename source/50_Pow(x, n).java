public class Solution {
    public double myPow(double x, int n) {
            if (x == 0) return 0; 
            if (x == 1) return 1;
            if (x == -1) return (n % 2) == 0 ? 1 : -1;
            if (n == 0) return 1; 
            if (n == 1) return x;
            if (n < 0 ) return myPow (1/x, -n);
            if (n == 2) return x * x;

            int halfPow = n/2; 

            return myPow(myPow(x,halfPow),2) * myPow(x, n%2); 
    }
}
