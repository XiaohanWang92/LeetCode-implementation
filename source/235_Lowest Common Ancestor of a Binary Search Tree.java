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
        TreeNode l = p.val < q.val ? p : q;
        TreeNode r = p.val > q.val ? p : q;
        return findSplit(root, l, r);
    }

    private TreeNode findSplit(TreeNode subRoot, TreeNode l, TreeNode r) {
        if(subRoot.val < l.val) {
            return findSplit(subRoot.right, l, r);
        } else if(subRoot.val>r.val) {
            return findSplit(subRoot.left, l, r);
        } else {
            return subRoot;
        }
    }
}
