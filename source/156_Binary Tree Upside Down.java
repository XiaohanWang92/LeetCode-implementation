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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))  return root;
        TreeNode curr = root;
        TreeNode newR = null;
        TreeNode newL = null;
        TreeNode next = null;
        while(curr != null) {
            next = curr.left;
            curr.left = newL;
            newL = curr.right;
            curr.right = newR;
            newR = curr;
            curr =next;
        }
        return newR;
    }
}
