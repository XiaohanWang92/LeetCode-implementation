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
    private boolean isFound;
    private int rank;
    private int res;
    public int kthSmallest(TreeNode root, int k) {
        rank = k;
        inorderWalk(root);
        return res;
    }
    private void inorderWalk(TreeNode root){
        if(isFound) return;
        if(root.left!=null) inorderWalk(root.left);
        rank--;
        if(rank==0){
            res = root.val;
            isFound = true;
            return;
        }
        if(root.right!=null)    inorderWalk(root.right);
    }
}
