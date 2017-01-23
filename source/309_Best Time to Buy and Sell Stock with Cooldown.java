public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        if(prices.length == 2)   return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] cooldown = new int[len];
        int[] sell = new int[len];

        // three arrays represent profit in ith day with different 3 states
        // each state stores current possible obtainable profit in such state
        // remember we are buy-in and sell multiple times for ONLY ONE stock
        buy[0] = -prices[0];
        cooldown[0] = 0;
        sell[0] = Integer.MIN_VALUE;
        for(int i = 1; i < len; i++) {

            // not buy in stock or buy in
            buy[i] = Math.max(buy[i - 1], buy[i - 1] - prices[i]);

            // sell holding stock, current price (profit) is price[i]
            sell[i] = buy[i - 1] + prices[i];

            // still hold-on or cooldown after sell
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }
        return Math.max(cooldown[len - 1], sell[len - 1]);
    }
}
