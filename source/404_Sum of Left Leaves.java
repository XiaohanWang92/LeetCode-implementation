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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)    return 0;
        if(root.left == null && root.right == null) return 0;
        int[] result = new int[1];
        if(root.left != null)
            countAndSumLeftLeaves(result, root.left, true);
        if(root.right != null)
            countAndSumLeftLeaves(result, root.right, false);
        return result[0];
    }
    
    private void countAndSumLeftLeaves(int[] result, TreeNode node, boolean isOnLeft) {
        if(node.left == null && node.right == null && isOnLeft) {
            result[0] += node.val;
            return;
        }
        if(node.left != null) {
            countAndSumLeftLeaves(result, node.left, true);
        }
        if(node.right != null) {
            countAndSumLeftLeaves(result, node.right, false);
        }
    }
}
