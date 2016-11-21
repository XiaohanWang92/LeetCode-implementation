public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(result, path, num, 0, target, 0, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder path, String num, int position, int target, long prev, long prevMulti) { 
        if(position == num.length()) {
            if(target == prev) result.add(path.toString());
            return;
        }
        for(int i = position; i < num.length(); i++) {
    
            // deal with avoiding number with form of '0123'
            if(num.charAt(position) == '0' && i != position) break;
            long curr = Long.parseLong(num.substring(position, i + 1));
            int length = path.length();
            if(position == 0) {
                dfs(result, path.append(curr), num, i + 1, target, curr, curr); 
                path.setLength(length);
            } else {
                dfs(result, path.append("+").append(curr), num, i + 1, target, prev + curr, curr); 
                path.setLength(length);
                dfs(result, path.append("-").append(curr), num, i + 1, target, prev - curr, -curr); 
                path.setLength(length);
                dfs(result, path.append("*").append(curr), num, i + 1, target, prev - prevMulti + prevMulti * curr, prevMulti * curr); 
                path.setLength(length);
            }
        }
    }
}