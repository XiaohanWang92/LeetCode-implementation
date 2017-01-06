public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> tmp = new LinkedList<>();
        Deque<Integer> inorder = new LinkedList<>();
        for (int val : preorder) {
            if(!inorder.isEmpty() && inorder.peek() > val)
                return false;
            while(!tmp.isEmpty() && val > tmp.peek())
                inorder.push(tmp.pop());
            tmp.push(val);
        }
        return true;
    }
}
