/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// old solution
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

// new solution
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
        if(root == null)    return true;
        if(root.left == null && root.right == null)
            return true;
        if(root.left == null || root.right == null)
            return false;
        if(root.left.val != root.right.val)
            return false;
        return isSymmetricSubtree(root.left, root.right);
    }
    
    private boolean isSymmetricSubtree(TreeNode treeL, TreeNode treeR) {
        if(treeL == null && treeR == null)  return true;
        if(treeL == null || treeR == null)  return false;
        TreeNode treeLLeft = treeL.left;
        TreeNode treeLRight = treeL.right;
        TreeNode treeRLeft = treeR.left;
        TreeNode treeRRight = treeR.right;
        if(treeLLeft == null) {
            if(treeRRight != null)
                return false;
        } else {
            if(treeRRight == null || treeLLeft.val != treeRRight.val)
                return false;
        }
        if(treeLRight == null) {
            if(treeRLeft != null)
                return false;
        } else {
            if(treeRLeft == null || treeLRight.val != treeRLeft.val)
                return false;
        }
        return isSymmetricSubtree(treeLLeft, treeRRight) && isSymmetricSubtree(treeLRight, treeRLeft);
    }
}
