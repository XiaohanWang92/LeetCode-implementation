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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || inorder.length != preorder.length)
            return null;
        TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if(ps > pe || is > ie)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int i = 0;
        for(i = is; is <= ie; is++) {
            if(inorder[i] == preorder[ps])
                break;
        }
        int leftTreeSize = i - is;
        root.left = buildTree(preorder, inorder, ps + 1, ps + leftTreeSize, is, i - 1);
        root.right = buildTree(preorder, inorder, ps + leftTreeSize + 1, pe, i + 1, ie);
        return root;
    }
}

