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
    private boolean isBalanced=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return isBalanced;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        isBalanced=(Math.abs(leftH-rightH)>1)?false:isBalanced;//be careful
        return isBalanced;
    }
    private int height(TreeNode subRoot){
        if(subRoot==null)   return 0;
        int lh = height(subRoot.left);
        int lr = height(subRoot.right);
        if(Math.abs(lh-lr)>1)   isBalanced=false;
        return 1+(lh>lr?lh:lr);
    }
}
