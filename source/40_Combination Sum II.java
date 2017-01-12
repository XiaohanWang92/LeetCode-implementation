public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)    return result;
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, result, combine, 0);
        return result;
    }

    private void findSum(int[] can, int t, List<List<Integer>> result, List<Integer> combine, int pos) {
        if(t < 0)   return;
        if(t == 0) {
            result.add(new ArrayList<Integer>(combine));
        }
        for(int i = pos; i < can.length; i++) {
            if(i != pos && can[i] == can[i - 1])
                continue;
            combine.add(can[i]);
            findSum(can, t - can[i], result, combine, i + 1);
            combine.remove(combine.size() - 1);
        }
    }
}

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)    return result;
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, result, combine, 0);
        return result;
    }

    private void findSum(int[] can, int t, List<List<Integer>> result, List<Integer> combine, int pos) {
        if(t < 0)   return;
        if(t == 0) {
            result.add(new ArrayList<Integer>(combine));
        }
        Set<Integer> set = new HashSet<>();
        for(int i = pos; i < can.length; i++) {
            if(set.contains(can[i]))
                continue;
            combine.add(can[i]);
            set.add(can[i]);
            findSum(can, t - can[i], result, combine, i + 1);
            combine.remove(combine.size() - 1);
        }
    }
}
