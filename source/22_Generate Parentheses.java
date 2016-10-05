//use StringBuilder can be faster!
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n == 0)  return result;
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, 0, 0, sb, result);
        return result;
    }

    private void generateParenthesis(int total, int left, int right, StringBuilder sb, List<String> result) {
        if(total == left && total == right) {
            result.add(sb.toString());
            return;
        }
        if(left < total) {
            sb.append('(');
            generateParenthesis(total, left + 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(left > right) {
            sb.append(')');
            generateParenthesis(total, left, right + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        if(n == 0) return result;
        helper(result, "", 0, 0 ,n);
        return result;
    }

    private void helper(List<String> result, String s, int left, int right, int pair) {
        if(s.length() == 2 * pair) {
            result.add(s);
            return;
        }
        if(left < pair)
            helper(result, s + "(", left + 1, right, pair);
        if(right < left)
            helper(result, s + ")", left, right + 1, pair);
    }
}
