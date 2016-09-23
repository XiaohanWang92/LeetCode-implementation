public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    if(s.charAt(i) == ')' && stack.pop() != '(')
                        return false;
                    if(s.charAt(i) == ']' && stack.pop() != '[')
                        return false;
                    if(s.charAt(i) == '}' && stack.pop() != '{')
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
