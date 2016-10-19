public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s == null) {
            return new ArrayList<String>();
        }
        List<String> results = new ArrayList<>();
        Set<String> checkedSet = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean findResultAtThisLevel = false;
        q.offer(s);
        checkedSet.add(s);
        while(q.size() != 0) {
            String current = q.poll();
            if(isValid(current)) {
                results.add(current);
                findResultAtThisLevel = true;
            }

            // If we already find result in this level, we stop generating next level's strings 
            if(findResultAtThisLevel)   continue;
            for(int i = 0; i < current.length(); i++) {
                if(current.charAt(i) == '(' || current.charAt(i) == ')') {
                    String remove = current.substring(0, i) + current.substring(i + 1);

                    // If we find duplication candidate, we won't BFS it any more
                    if(!checkedSet.contains(remove)) {
                        q.offer(remove);
                        checkedSet.add(remove);
                    }
                }
            }
        }
        return results;
    }
    
    private boolean isValid(String s) {
        if(s.equals(""))    return true;
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '(')    count++;
            else if(c == ')')   count--;
            if(count < 0)   return false;
        }
        return count == 0 ? true : false;
    }
}
