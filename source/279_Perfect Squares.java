public class Solution {
    public int numSquares(int n) {
        if(n<0) return 0;
        int[] squareSumTo = new int[n+1];
        squareSumTo[0] = 0;
        for(int i=1; i<n+1; i++){
            int currmin = Integer.MAX_VALUE;
            int j = 1;
            while(i-Math.pow(j, 2)>=0){
                currmin = Math.min(squareSumTo[i-j*j]+1, currmin);
                j++;
            }
            squareSumTo[i] = currmin;
        }
        return squareSumTo[n];
    }
}
