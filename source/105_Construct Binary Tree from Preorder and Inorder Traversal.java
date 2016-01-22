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
        if(preorder==null || inorder==null || preorder.length!=inorder.length)  return null;
        TreeNode root = findRoot(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }
    private TreeNode findRoot(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
        if(pl>pr || il>ir)  return null;
        TreeNode subroot = new TreeNode(preorder[pl]);
        int rootIndexInorder = il;
        for(int i = il; i<=ir; i++){
            if(inorder[i]==preorder[pl]){
                rootIndexInorder = i;
                break;
            }
        }
        int leftSubtreeRange = rootIndexInorder - il;
        subroot.left = findRoot(preorder, pl+1, pl+leftSubtreeRange, inorder, il, rootIndexInorder-1);
        subroot.right = findRoot(preorder, pl+leftSubtreeRange+1, pr, inorder, rootIndexInorder+1, ir);
        return subroot;
    }
}
