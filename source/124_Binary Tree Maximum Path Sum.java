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
    
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return max;
    }
    
    private int findMaxPathSum(TreeNode root) {
        if(root == null)    return 0;
        int leftSum = findMaxPathSum(root.left);
        int rightSum = findMaxPathSum(root.right);
        
        // When sub tree sum is negative, we use 0 to indicate that such path cannot be chosen
        int leftMax = Math.max(0, leftSum);
        int rightMax = Math.max(0, rightSum);
        
        // Update max each time. each path will pass some common ancestor, 
        // even if the result path is on subtree of current node but does not pass current node
        // the max has been updated before
        max = Math.max(max, leftMax + rightMax + root.val);
        return root.val + Math.max(leftMax, rightMax);
    }
}
