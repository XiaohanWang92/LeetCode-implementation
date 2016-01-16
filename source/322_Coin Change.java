public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1)    return 0;
        int[] dp = new int[amount+1];//dp[n]: number of coins to make a change for amount n
        for(int i = 1; i<=amount; i++){
            int minNum = -1;
            for(int coin : coins){
                if(i>=coin && dp[i-coin]!=-1){
                    int currNum = dp[i-coin]+1;
                    minNum = minNum ==-1? currNum : (minNum < currNum? minNum:currNum);
                }
            }
            dp[i] = minNum;
        }
        
        return dp[amount];
    }
}
