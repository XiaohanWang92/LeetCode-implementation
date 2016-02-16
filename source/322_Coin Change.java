public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount<0)   return -1;
        if(amount == 0)    return 0;
        //dp[i] means to make a chage for money i, the min number of coins that we need
        //dp[i] == -1 means that cannot make a change based on the denominations provided
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<amount+1; i++){
            int min = Integer.MAX_VALUE;
            for(int c : coins){
                if(i-c>=0 && dp[i-c] != -1){
                    min = Math.min(dp[i-c] + 1, min);
                }
            }
            dp[i] = min == Integer.MAX_VALUE? -1 : min;
        }
        return dp[amount];
    }
}
