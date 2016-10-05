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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)  return null;
        TreeNode succ = null;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.val > p.val) {
                succ = curr;
                curr = curr.left;
                
            } else {
                curr = curr.right;
            }
        }
        return succ;
    }   
}
