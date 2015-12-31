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
        TreeNode l = p.val<q.val?p:q;
        TreeNode r = p.val>q.val?p:q;
        return findSplit(root, l ,r);
    }
    private TreeNode findSplit(TreeNode subRoot, TreeNode l, TreeNode r){
        if(subRoot.val<l.val){
            return findSplit(subRoot.right, l, r);
            //must 'return', otherwise compiler will fire an error!
        }
        else if(subRoot.val>r.val){
            return findSplit(subRoot.left, l, r);
        }
        else{
            return subRoot;
            //now it must be the split node that: l.val<=splitNode.val<=r.val
        }
    }
}
