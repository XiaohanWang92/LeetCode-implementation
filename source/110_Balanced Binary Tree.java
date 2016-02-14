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
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        return heightCheck(root) != -1;
    }
    private int heightCheck(TreeNode root){
        if(root == null)    return 0;
        int l = heightCheck(root.left);
        if(l == -1) return -1;
        int r = heightCheck(root.right);
        if(r == -1) return -1;
        if(Math.abs(l-r)>1) return -1;
        return 1+Math.max(l,r);
    }
}

