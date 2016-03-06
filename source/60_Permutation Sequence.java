public class Solution {
    public String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0)    return "";
        List<Integer> list = new ArrayList<Integer>();
        int[] fac = new int[n+1];
        //0! = 1
        fac[0] = 1;
        //factorial[] = {1, 1, 2, 6, 24, ... n!}
        //add numbers in a list
        for(int i = 1; i <= n; i++){
            fac[i] = fac[i-1] * i;
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        //get index, update and generate permutation
        for(int i = n; i >= 1; i--){
            int idx = k/fac[i-1];
            sb.append(list.get(idx));
            k = k - fac[i-1]*idx;
            list.remove(idx);
        }
        return sb.toString();
    }
}
