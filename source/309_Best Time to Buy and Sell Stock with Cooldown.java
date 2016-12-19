public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        if(prices.length == 2)   return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] hold = new int[len];
        int[] sell = new int[len];

        // three arrays represent profit in ith day with different 3 states
        buy[0] = -prices[0];
        hold[0] = 0;
        sell[0] = Integer.MIN_VALUE;
        for(int i = 1; i < len; i++) {

            // hold bought stock or buy in
            buy[i] = Math.max(buy[i - 1], hold[i - 1] - prices[i]);

            // sell stock in holding
            sell[i] = buy[i - 1] + prices[i];

            // still hold or cooldown after sell
            hold[i] = Math.max(hold[i - 1], sell[i - 1]);
        }
        return Math.max(hold[len - 1], sell[len - 1]);
    }
}
