public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0)  return false;
        if(preorder.equals("#"))    return true;
        LinkedList<String> stack = new LinkedList<>();
        String[] node = preorder.split(",");
        for(String s : node) {
            if(!s.equals("#") || stack.size() == 0) {
                stack.push(s);
            } else {
                String t = stack.peek();
                if(t.equals("#")) {
                    while(stack.size() > 0 && stack.peek().equals("#")) {
                        if(pop2ele(stack) == false)   return false;
                    }
                    stack.push("#");
                } else {
                    stack.push(s);
                }
            }
        }
        if(stack.size() == 1 && stack.peek().equals("#"))   return true;
        return false;
    }

    private boolean pop2ele(LinkedList<String> stack) {
        if(stack.size() < 2)  return false;
        stack.pop();
        stack.pop();
        return true;
    }
}
