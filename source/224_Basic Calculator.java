public class Solution {

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int sign = 1;
        int previousNumber = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                previousNumber = 10 * previousNumber + Integer.parseInt(Character.toString(c));
            } else if (c == '+') {
                result = result + previousNumber * sign;//add last number to result
                previousNumber = 0;//reset previousNumber for new previousNumber in next loop
                sign = 1;//set current sign
            } else if (c == '-') {
                result = result + previousNumber * sign;
                previousNumber = 0;
                sign =- 1;
            } else if(c == '(') {
                stack.push(sign);
                stack.push(result);
                sign = 1;//need to remember to reset sign!
                result = 0;
                //no need to reset previousNumber because legal expression excludes 1+2(3-4), before left parentheses there must be a '-' or '+'
            } else if(c==')') {
                result = result + previousNumber * sign;
                int prevousResult = stack.pop();
                int parenSign = stack.pop();
                result *= parenSign;
                result += prevousResult;
                previousNumber = 0;
            }
        }
        result += previousNumber * sign; //add on last number in the tail
        return result;
    }
}
