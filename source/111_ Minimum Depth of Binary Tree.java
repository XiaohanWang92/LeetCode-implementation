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
    public int minDepth(TreeNode root) {
        if(root == null)  return 0;
        int leftSubTreeDepth = minDepth(root.left);
        int rightSubTreeDepth = minDepth(root.right);
        if(leftSubTreeDepth == 0 || rightSubTreeDepth == 0) {
            return leftSubTreeDepth == 0 ? rightSubTreeDepth + 1 : leftSubTreeDepth + 1;
        }
        return Math.min(leftSubTreeDepth, rightSubTreeDepth) + 1;
    }
}
