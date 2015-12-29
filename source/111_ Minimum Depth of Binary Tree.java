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
        if(root==null)  return 0;
        int leftSubTree = minDepth(root.left);
        int rightSubTree = minDepth(root.right);
        if(leftSubTree==0||rightSubTree==0){
            return leftSubTree==0?rightSubTree+1:leftSubTree+1;//include root node
        }
        return Math.min(leftSubTree,rightSubTree)+1;
    }
}
