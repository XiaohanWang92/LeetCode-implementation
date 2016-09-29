public class Solution {
    public int[] countBits(int num) {
        if(num <= 0)
            return new int[1];
        int[] dp = new int[num + 1];
        dp[1] = 1;
        int power2 = 2, index = 2;
        while(index <= num) {
            if(index == power2) {
                power2 *= 2;
                dp[index] = 1;
                index++;
            } else {
                dp[index] = 1 + dp[index - power2 / 2];
                index++;
            }
        }
        return dp;
    }
}

//other folk's genius idea
public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
}