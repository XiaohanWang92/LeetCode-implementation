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
    
    TreeNode previous = null;
    
    public void flatten(TreeNode root) {
        if(root == null)    return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = previous;
        previous = root;
    }
}
