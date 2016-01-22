public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k==0 || n==0)    return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        int[] number = {1,2,3,4,5,6,7,8,9};
        backtrack(k, n, res, track, number, 0);
        return res;
    }
    private void backtrack(int count, int tar, List<List<Integer>> res, List<Integer> track, int[] number, int pos){
        if(count==0 && tar==0){
            res.add(new ArrayList<Integer>(track));
            return;
        }
        if((count==0 && tar!=0) || tar<0) return;
        for(int i=pos; i<9; i++){
            track.add(number[i]);
            backtrack(count-1, tar-number[i], res, track, number, i+1);
            track.remove(track.size()-1);
        }
    }
}
