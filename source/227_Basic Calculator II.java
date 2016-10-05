public class Solution {

    public int calculate(String s) {
        if(s == null || s.length() == 0)  return 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int number = 0;
        char previousSign = '+';
        for(char c : s.toCharArray()) {
            if(c == ' ')  continue;
            if(Character.isDigit(c)) {
                number = 10 * number + (c - '0');
            }
            if(!Character.isDigit(c)) {
                if(previousSign == '+') {
                    stack.push(number);
                } else if(previousSign == '-') {
                    stack.push(number * (-1));
                } else if(previousSign == '/') {
                    stack.push(stack.pop() / number);
                } else if(previousSign == '*') {
                    stack.push(stack.pop() * number);
                }
                number = 0;
                previousSign = c;
            }
        }
        int result = 0;
        if(previousSign == '+') {
            stack.push(number);
        } else if(previousSign == '-') {
            stack.push(number * (-1));
        } else if(previousSign == '/') {
            stack.push(stack.pop() / number);
        } else if(previousSign == '*') {
            stack.push(stack.pop() * number);
        }
        for(int res : stack){
            result += res;
        }
        return result;
    }
}
