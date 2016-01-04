public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE, maxPriceDiff=0;
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice, prices[i]);//maintain current min price
            maxPriceDiff=Math.max(maxPriceDiff, prices[i]-minPrice);//maintain current max price difference
        }
        return maxPriceDiff;
    }
}
//solution II
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int[] priceDiff=new int[prices.length-1];
        for(int i=0;i<priceDiff.length;i++){
            priceDiff[i]=prices[i+1]-prices[i];
        }
        int maxPro= maxSubarray(priceDiff);
        return maxPro;
    }
    private int maxSubarray(int[] nums){
        if(nums==null||nums.length<0)   return 0;
        int maxSub=0;
        int preMax=0;
        for(int i=0;i<nums.length;i++){
            maxSub=Math.max(maxSub, preMax+nums[i]);
            preMax=(preMax+nums[i])<0?0:preMax+nums[i];
        }
        return maxSub;
    }
}
