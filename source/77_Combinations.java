public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0)    return new ArrayList<List<Integer>>();
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findCombine(1, n, k, results, path);
        return results;
    }
    
    private void findCombine(int start, int n, int k, List<List<Integer>> results, List<Integer> path) {
        if(k == 0) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = start; i <= n; i++) {
            path.add(i);
            findCombine(i + 1, n, k - 1, results, path);
            path.remove(path.size() - 1);
        }
    }
}
