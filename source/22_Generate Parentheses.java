public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if(n==0) return res;
        helper(res, "", 0, 0 ,n);
        return res;
    }
    private void helper(List<String> res, String s, int left, int right, int pair){
        if(s.length()==2*pair){
            res.add(s);
            return;
        }
        if(left<pair)
            helper(res, s+"(", left+1, right, pair);
        if(right<left)
            helper(res, s+")", left, right+1, pair);
    }
}
