public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign=1;
        int preNum=0;
        int result=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                preNum = 10*preNum+Integer.parseInt(Character.toString(c));
            }else if(c=='+'){
                result = result + preNum*sign;//add last number to result
                preNum=0;//reset preNum for new preNum in next loop
                sign=1;//set current sign
            }else if(c=='-'){
                result = result + preNum*sign;
                preNum=0;
                sign=-1;
            }else if(c=='('){
                stack.push(sign);
                stack.push(result);
                sign=1;//need to remember to reset sign!
                result=0;
                //no need to reset preNum because legal expression excludes 1+2(3-4), before left parentheses there must be a '-' or '+'
            }else if(c==')'){
                result = result + preNum*sign;
                int preRes = stack.pop();
                int parenSign = stack.pop();
                result *= parenSign;
                result += preRes;
                preNum=0;
            }
        }
        result += preNum*sign; //add on last number in the tail
        return result;
    }
}
