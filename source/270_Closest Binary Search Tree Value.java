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
    public int closestValue(TreeNode root, double target) {
        int currVal = root.val;
        while(root != null) {
            currVal = Math.abs(target - currVal) < Math.abs(target - root.val) ? currVal : root.val;
	        if(currVal == target) return currVal;
            root = root.val > target ? root.left : root.right;
        }
        return currVal;
    }
}
