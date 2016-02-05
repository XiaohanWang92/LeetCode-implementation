public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //O(k*n)
        if(n == 1)  return 1;
        int[] superU = new int[n];
        superU[0] = 1;
        int k = primes.length;
        int[] index = new int[k];
        int[] multiple = new int[k];
        for(int i=0; i<k; i++){
            multiple[i] = primes[i];
        }
        for(int i=1; i<n; i++){
            int min = Integer.MAX_VALUE;
            for(int m : multiple)
                min = Math.min(min, m);
                superU[i] = min;
            for(int j=0; j<k; j++){
                if(min == multiple[j]){
                    index[j]++;
                    multiple[j] = superU[index[j]]*primes[j];
                }
            }
        }
        return superU[n-1];
    }
}
