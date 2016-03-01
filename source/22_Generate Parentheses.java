//use StringBuilder can be faster!
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n == 0)  return res;
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, 0, 0, sb, res);
        return res;
    }
    private void generateParenthesis(int total, int left, int right, StringBuilder sb, List<String> res){
        if(total == left && total == right){
            res.add(sb.toString());
            return;
        }
        if(left < total){
            sb.append('(');
            generateParenthesis(total, left+1, right, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(left > right){
            sb.append(')');
            generateParenthesis(total, left, right+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

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
