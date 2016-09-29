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
    public int largestBSTSubtree(TreeNode root) {
        int[] results = recursive(root);
        return results[2];
    }

    private int[] recursive(TreeNode root) {
        int[] results = new int[5];
        results[0] = 1;
        results[3] = Integer.MAX_VALUE;
        results[4] = Integer.MIN_VALUE;

        // Index notation: 0 - whether is BST; 1 - No. of nodes; 2 - max BST subtree; 3 - min value; 4 - max value
        if (root == null) return results;
        int[] resultsL = recursive(root.left);
        int[] resultsR = recursive(root.right);
        if (resultsL[0] == 0 || resultsR[0] == 0 || resultsL[4] > root.val || root.val > resultsR[3])
            results[0] = 0;
        results[1] = resultsL[1] + resultsR[1] + 1;
        results[2] = (results[0] > 0) ? results[1] : (Math.max(resultsL[2], resultsR[2]));
        if(results[0] != 0) {
            results[3] = Math.min(root.val, Math.min(resultsL[3], resultsR[3]));
            results[4] = Math.max(root.val, Math.max(resultsL[4], resultsR[4]));
        }
        return results;
    }
}
