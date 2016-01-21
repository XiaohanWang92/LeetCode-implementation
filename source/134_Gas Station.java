public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int tank = 0;
        int gasSum = 0;
        int costSum = 0;
        for(int i=0; i<gas.length; i++){
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
        //first one cannot reach
            if(tank<0){
                tank = 0;
                start = i+1;
            }
        }
        if(gasSum >= costSum)
            return start;
        else
            return -1;
    }
}
