public class Solution {
    public int climbStairs(int n) {
        if(n <= 0)    return 0;
        if(n == 1)    return 1;
        if(n == 2)    return 2;
        int step1ToCurr = 2;
        int step2ToCurr = 1;
        int currWays = 0;

        // iteratively caculate number of ways to height from 3 to n
        for(int i = 3; i <= n; i++) {

            // numOfWay[k] = numOfWay[k - 1] + numOfWay[k - 2] (one more 1 step or 2 step)
            currWays = step1ToCurr + step2ToCurr;

            // for next k + 1, reach k - 1 then take one 2 step, so to reach k + 1, now there are ways:
            step2ToCurr = step1ToCurr;

            // for next k + 1, reach k then take one 1 step, so to reach k, now there are ways:
            step1ToCurr = currWays;
        }
        return currWays;
    }
}
