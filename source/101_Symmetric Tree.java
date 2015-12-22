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
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        boolean isSymmetric = checkSymmetric(root.left, root.right);
        return isSymmetric;
    }
    private boolean checkSymmetric(TreeNode left, TreeNode right){
        if(left==null && right ==null)
            return true;
        if((left!=null&&right==null)||(right!=null&&left==null))
            return false;
        //now reaching leave test has been done
        if(left.val==right.val){
            boolean isTemp=checkSymmetric(left.left, right.right)&&checkSymmetric(left.right,right.left);
            return isTemp;
        }
        else
            return false;
    }
}