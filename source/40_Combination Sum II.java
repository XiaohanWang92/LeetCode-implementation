public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)    return res;
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, res, combine, 0);
        return res;
    }
    private void findSum(int[] can, int t, List<List<Integer>> res, List<Integer> combine, int pos){
        if(t < 0)   return;
        if(t == 0){
            res.add(new ArrayList<Integer>(combine));
        }
        for(int i = pos; i < can.length; i++){
            if(i != pos && can[i] == can[i-1])
                continue;
            combine.add(can[i]);
            findSum(can, t - can[i], res, combine, i + 1);
            combine.remove(combine.size()-1);
        }
    }
}
