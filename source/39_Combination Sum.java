public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return results;
        Arrays.sort(candidates);
        backtrack(results, track, candidates, target, 0);
        return results;
    }
    private void backtrack(List<List<Integer>> results, List<Integer> track, int[] candidate, int target, int pos) {
        if(target < 0)   return;
        else if(target == 0) {
            results.add(new ArrayList(track));
            return;
        } else { 
            for(int i = pos; i < candidate.length; i++) {
                track.add(candidate[i]);
                backtrack(results, track, candidate, target - candidate[i], i);
                track.remove(track.size() - 1);
            }
        }
    }
}
