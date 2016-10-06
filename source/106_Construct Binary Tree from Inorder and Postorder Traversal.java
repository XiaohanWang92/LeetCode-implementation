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

    private HashMap<Integer, Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        for(int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode build(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if(istart > iend || pstart > pend)   return null;
        TreeNode subroot = new TreeNode(postorder[pend]);
        int rootPos = index.get(postorder[pend]);
        int leftSubNum = rootPos - istart;
        subroot.left = build(inorder, istart, rootPos - 1, postorder, pstart, pstart + leftSubNum - 1);
        subroot.right  = build(inorder, rootPos + 1, iend, postorder, pstart + leftSubNum, pend - 1);
        return subroot;
    }
}

// not use hash map:
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if(is > ie || ps > pe) return null;
        int rootVal = postorder[pe];
        int rootIndex = 0;
        for(int i = is; i <= ie; i++) {
            if(inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = buildTree(inorder, postorder, is, rootIndex - 1, ps, ps + rootIndex - is - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, ie, ps + rootIndex - is, pe - 1);
        return root;
    }
}

