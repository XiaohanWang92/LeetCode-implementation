public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)    return 0;
        int maxProfitBuyInFirstTime = -prices[0],
            maxProfitSellFirstTime = 0,
            maxProfitBuyInSecondTime = -prices[0],
            maxProfitSellSecondTime = 0;
        for(int i = 1; i < prices.length; i++) {
            int price = prices[i];
            
            // states may use previous state profit information to dp
            // so order is important, for example, second sell needs to know previous second buy-in information
            // so second buy-in information should be updated later
            maxProfitSellSecondTime = Math.max(maxProfitSellSecondTime, maxProfitBuyInSecondTime + price);
            maxProfitBuyInSecondTime = Math.max(maxProfitBuyInSecondTime, maxProfitSellFirstTime - price);
            maxProfitSellFirstTime = Math.max(maxProfitSellFirstTime, maxProfitBuyInFirstTime + price);
            maxProfitBuyInFirstTime = Math.max(maxProfitBuyInFirstTime, -price);
        }
        return maxProfitSellSecondTime;
    }
}
