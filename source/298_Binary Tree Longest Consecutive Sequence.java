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
    int maxLen;
    public int longestConsecutive(TreeNode root) {
        if(root==null)  return 0;
        pathWalk(root, 1);
        return maxLen;
    }
    private void pathWalk(TreeNode root, int curr){
        if(root==null)  return;
        if(root.left!=null && root.val+1==root.left.val){
            pathWalk(root.left, curr+1);
        }else{
            maxLen = Math.max(curr, maxLen);
            pathWalk(root.left, 1);
        }
        if(root.right!=null && root.val+1==root.right.val){
            pathWalk(root.right, curr+1);
        }else{
            maxLen = Math.max(curr, maxLen);
            pathWalk(root.right, 1);
        }
    }
}
