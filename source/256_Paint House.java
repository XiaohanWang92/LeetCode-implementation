public class Solution {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0)    return 0;//no house to paint
        int preRed=costs[0][0];
        int preBlue=costs[0][1];
        int preGreen=costs[0][2];
        for(int i=1;i<costs.length;i++){
            int currRed = Math.min(preBlue, preGreen)+costs[i][0];
            int currBlue = Math.min(preRed, preGreen)+costs[i][1];
            int currGreen = Math.min(preRed, preBlue)+costs[i][2];
            preRed = currRed;
            preBlue = currBlue;
            preGreen = currGreen;
        }
        return Math.min(preRed, Math.min(preBlue, preGreen));
    }
}
