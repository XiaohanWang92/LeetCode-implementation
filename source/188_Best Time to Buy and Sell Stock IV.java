// Correct but Memory Limited Exceed (209 / 211)
// I think this is better for it directly adopts idea in Problem 123 for me, it is easy to remember and understand
// Single array length cannot exceed certain length in LeetCode
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k <= 0 || prices == null || prices.length <= 1)  return 0;

        // sellStockProfit[j] means possible max profit get when sell stock (j + 1) time
        // rationale also applies to buyStockProfit array
        int[] sellStockProfit = new int[k];
        int[] buyStockProfit = new int[k];
        for(int i = 0; i < k; i++) {
            buyStockProfit[i] = -prices[0];
        }
        for(int i = 1; i < prices.length; i++) {
            int price = prices[i];

            // like problem 123, order is important
            // sell stock ith time depends on information of buy stock ith time
            // so buy stock ith time should be updated later
            for(int j = k - 1; j > 0; j--) {
                sellStockProfit[j] = Math.max(sellStockProfit[j], buyStockProfit[j] + price);
                buyStockProfit[j] = Math.max(buyStockProfit[j], sellStockProfit[j - 1] - price);
            }
            sellStockProfit[0] = Math.max(sellStockProfit[0], buyStockProfit[0] + price);
            buyStockProfit[0] = Math.max(buyStockProfit[0], -price);
        }
        return sellStockProfit[k - 1];
    }
}
