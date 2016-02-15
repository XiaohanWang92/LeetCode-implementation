public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)  return 0;
        int houseNum = costs.length;
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        
        for(int i=1; i<houseNum; i++){
            int prevRed = red;
            int prevBlue = blue;
            int prevGreen = green;
            blue = Math.min(prevGreen + costs[i][1],  prevRed + costs[i][1]);
            green = Math.min(prevBlue + costs[i][2], prevRed + costs[i][2]);
            red = Math.min(prevGreen + costs[i][0], prevBlue + costs[i][0]);
        }
        
        return Math.min(red, Math.min(green, blue));
    }
}
