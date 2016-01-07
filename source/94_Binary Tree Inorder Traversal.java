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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null)    return res;
        inorderWalk(root, res);
        return res;
    }
    private void inorderWalk(TreeNode root, List<Integer> res){
        if(root==null)  return;
        inorderWalk(root.left, res);
        res.add(root.val);
        inorderWalk(root.right, res);
    }
}
/*use stack*/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode>  stack = new Stack<>();
        TreeNode pos = root;
        while(pos!=null||!stack.isEmpty()){
            while(pos!=null){
                stack.push(pos);
                pos = pos.left;
            }
            pos = stack.pop();
            res.add(pos.val);
            pos = pos.right;
        }
        return res;
    }
}
