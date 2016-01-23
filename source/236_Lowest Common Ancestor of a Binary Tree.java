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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root==null)  return null;
        if(root==p || root==q)  return root;
        //find if p and q are both in left or right subtree
        //then lca will be return from recursive call
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null && right==null)//can't find p and q in this tree
            return null;
        else if(left!=null && right!=null)//p and q are in different subtree, lca is root
            return root;
        else if(left!=null && right==null)//q p are in left subtree, lca is return reference
            return left;
        else//q p are in right subtree, lca is return reference
            return right;
    }
}
