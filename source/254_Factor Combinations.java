public class Solution {
    public List<List<Integer>> getFactors(int n) {
        if(n<4) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> trace = new ArrayList<Integer>();
        getFactors(n, 2, n, res, trace);
        return res;
    }
    private void getFactors(int n, int start, int end, List<List<Integer>> res, List<Integer> trace){
        if(end==1){
            res.add(new ArrayList<Integer>(trace));
            return;
        }
        for(int i=start; i<=end; i++){
            if(end%i==0 && i!=n){
                trace.add(i);
                getFactors(n, i, end/i, res, trace);
                trace.remove(trace.size()-1);
            }
        }
    }
}
