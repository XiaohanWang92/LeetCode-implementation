public class Solution {
    public double myPow(double x, int n){
        return myPow(x, (long)n);
    }
    public double myPow(double x, long n) {
        if(x == 0)  return 0.0;
        if(x == 1)  return 1.0;
        if(x == -1) return n % 2 == 0 ? 1.0 : -1.0;
        if(n == 0)  return 1.0;
        if(n == 1)  return x;
        if(n == 2)  return x*x;
        //if n = -2147483648, convert it to positive will overflow if data type is int
        //so we use a overload method to deal with it
        if(n < 0)   return myPow(1/x, (long)(-n));//deal with n = -2147483648
        long halfPow = n/2;
        return myPow(myPow(x, halfPow), (long)2) * myPow(x, (long)(n % 2 == 0 ? 0 : 1));
    }
    
}
//or iterative way
public double myPow(double x, int n) {
    x = (n > 0) ? x : 1 / x;
    double ans = 1;
    for (double y = x; n != 0; n /= 2) {
        if (n % 2 != 0) ans *= y;
        y *= y;
    }
    return ans;
}
