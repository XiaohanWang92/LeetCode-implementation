public class Solution {
    public List<List<Integer>> getFactors(int n) {
        if(n < 4) return new ArrayList<List<Integer>>();
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> trace = new ArrayList<>();
        getFactors(n, 2, n, results, trace);
        return results;
    }

    private void getFactors(int n, int start, int end, List<List<Integer>> results, List<Integer> trace) {
        if(end == 1) {
            results.add(new ArrayList<Integer>(trace));
            return;
        }
        for(int i = start; i <= end; i++) {
            if(end % i == 0 && i != n) {
                trace.add(i);
                getFactors(n, i, end / i, results, trace);
                trace.remove(trace.size() - 1);
            }
        }
    }
}
