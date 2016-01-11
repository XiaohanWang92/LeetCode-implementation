public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        
        for(int i = 0; i<tokens.length; i++){
            if(isNumber(tokens[i])) stack.push(Integer.parseInt(tokens[i]));
            else{
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                if(tokens[i].equals("+"))   stack.push(operand1+operand2);
                else if(tokens[i].equals("-"))   stack.push(operand1-operand2);
                else if(tokens[i].equals("/"))   stack.push(operand1/operand2);
                else if(tokens[i].equals("*"))   stack.push(operand1*operand2);
            }
        }
        
        return stack.peek();
    }
    private boolean isNumber(String s){
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/"))  return false;
        return true;
    }
}
