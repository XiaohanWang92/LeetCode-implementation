public class Solution {
    
    int[] count = new int[26];
    boolean[] isInStack = new boolean[26];
    
    public String removeDuplicateLetters(String s) {
        if(s == null) return "";
        if(s.length() < 2)    return s;
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Deque<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()) {
            count[c - 'a']--;
            if(isInStack[c - 'a'])   continue;
            while(!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] != 0) {
                char tmp = stack.pop();
                isInStack[tmp - 'a'] = false;
            }
            stack.push(c);
            isInStack[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() != 0) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}

public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() <= 1)  return s;
        Map<Character, Integer> lastPosition = new HashMap<>();
        char[] cs = s.toCharArray();
        for(int index = 0; index < cs.length; index++) {
            lastPosition.put(cs[index], index);
        }
        
        // start find each interval's smallest char (build result letter by letter)
        int left = 0, right = findCurrentMinLastPostion(lastPosition);
        char[] results = new char[lastPosition.keySet().size()];
        for(int i = 0; i < results.length; i++) {
            char currentMin = 'z' + 1;
            
            // find smallest char in current interval
            for(int j = left; j <= right; j++) {
                if(cs[j] < currentMin && lastPosition.containsKey(cs[j])) {
                    
                    // update next checking's start point
                    left = j + 1;
                    currentMin = cs[j];
                }
            }
            results[i] = currentMin;
            
            // remove current letter
            lastPosition.remove(currentMin);
            
            // if current interval has been inspected, move to next interval
            if(cs[right] == currentMin)
                right = findCurrentMinLastPostion(lastPosition);
        }
        return String.valueOf(results);
    }
    
    private int findCurrentMinLastPostion(Map<Character, Integer> lastPosition) {
        if(lastPosition.keySet().size() == 0)  return -1;
        int index = Integer.MAX_VALUE;
        for(char c : lastPosition.keySet()) {
            int i = lastPosition.get(c);
            if(i < index)
                index = i;
        }
        return index;
    }
}
