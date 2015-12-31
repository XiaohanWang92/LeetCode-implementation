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
    private int currMax=0;
    public int maxDepth(TreeNode root) {
        if(root==null)  return 0;
        if(root.left==null&&root.right==null)   return 1;
        int depth=1;
        findDepthDFS(root, depth);
        return currMax;
    }
    private void findDepthDFS(TreeNode subRoot,int depth){
        if(subRoot.left==null&&subRoot.right==null){
            currMax=currMax>depth?currMax:depth;
        }
        if(subRoot.left!=null)
            findDepthDFS(subRoot.left, depth+1);
        if(subRoot.right!=null)
            findDepthDFS(subRoot.right, depth+1);
    }
}
