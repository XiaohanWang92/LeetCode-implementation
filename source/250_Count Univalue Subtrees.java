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
    private int count;

    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)  return 0;
        findUnivalSubtrees(root);
        return count;
    }

    private boolean findUnivalSubtrees(TreeNode root) {
        if(root == null)    return true;
        
        boolean l = findUnivalSubtrees(root.left);
        boolean r = findUnivalSubtrees(root.right);
        
        if(l&&r){
            if(root.left!=null && root.left.val!=root.val)  return false;
            if(root.right!=null && root.right.val!=root.val)    return false;
            count++;
            return true;
        }
        return false;
    }
}
