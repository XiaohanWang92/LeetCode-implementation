public class Solution {

    // time complexity: O(k*n)
    // entire ugly sequence can be merged from prime.length number of sequences
    // each sequence is itself multiplies each prime
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1)  return 1;
        int[] superU = new int[n];
        superU[0] = 1;
        int k = primes.length;

        // index stores index of current using number in ugly sequence for each prime
        int[] index = new int[k];
        int[] multiple = new int[k];
        for(int i = 0; i < k; i++) {
            multiple[i] = primes[i];
        }
        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int m : multiple)
                min = Math.min(min, m);
            superU[i] = min;
            for(int j = 0; j < k; j++) {

                // j maps each prime to the table
                // if current ugly number is found
                if(min == multiple[j]) {

                    // corresponding index is updated
                    index[j]++;

                    // get next ugly number, update corresponding next multipled-ugly number
                    multiple[j] = superU[index[j]] * primes[j];
                }
            }
        }
        return superU[n - 1];
    }
}
