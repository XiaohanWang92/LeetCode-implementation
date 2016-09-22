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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode subRoot, Integer intervalMin, Integer intervalMax){
        if(subRoot == null)   return true;
        if((intervalMin != null && subRoot.val <= intervalMin) || (intervalMax != null && subRoot.val >= intervalMax))
            return false;
        return helper(subRoot.left, intervalMin, subRoot.val) && helper(subRoot.right, subRoot.val, intervalMax);
    }
}
