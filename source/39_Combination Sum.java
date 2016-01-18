public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        if(candidates==null || candidates.length==0) return res;
        Arrays.sort(candidates);
        backtrack(res, track, candidates, target, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> track, int[] cand, int tar, int pos){
        if(tar<0)   return;
        else if(tar==0){
            res.add(new ArrayList(track));
            return;
        }
        else{
            for(int i=pos; i<cand.length; i++){
                track.add(cand[i]);
                backtrack(res, track, cand, tar-cand[i], i);
                track.remove(track.size()-1);
            }
        }
    }
}
