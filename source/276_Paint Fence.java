public class Solution {
    public int numWays(int n, int k) {
        if(n==0)    return 0;
        if(n==1) return k;
        int same=k;//last two posts are painted with same color
        int diff=k*(k-1);//last two posts are paintd with different colors
        //now start with the third post(index 2, index scope 0-(n-1)), let's paint
        for(int i=2;i<n;i++){
            int temp=diff;
            //new different color to paint ith post
            //use different color to last one(ith), choice is k-1
            //after painted, ith become last one, previous last one (i-1)th becomes last 2nd one
            //these two still are different colors
            diff=(k-1)*(same+diff);
            //only when the previous two have different colors, 
            //ith can have the same color with previous last one, (i-1)th
            same=temp;
        }
        return same+diff;
    }
}