/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        preorder(root, res);
        return res;
    }
    private void preorder(TreeNode root, List<Integer> res){
        if(root==null)  return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
/*solution without recursion*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if(root==null)  return res;
        stack.push(root);
        while(stack.size()!=0){
            TreeNode curr = stack.pop();
            if(curr!=null){
                res.add(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return res;
    }
}
