public class Solution {
    public int maxProfit(int[] prices) {
        int pro=0;
        if(prices==null||prices.length<2) return pro;
        if(prices.length==2)    return prices[1]>prices[0]?prices[1]-prices[0]:pro;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])   pro += prices[i]-prices[i-1];
        }
        return pro;
    }
}