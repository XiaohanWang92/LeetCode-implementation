public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n==0 || k>n || k==0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combine(0, k, 1, n, res, path);
        return res;
    }
    private void combine(int round, int k, int pos, int n, List<List<Integer>> res, List<Integer> path){
        if(round==k){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = pos; i<=n; i++){
            path.add(i);
            combine(round+1, k, i+1, n, res, path);
            path.remove(path.size()-1);
        }
    }
}
