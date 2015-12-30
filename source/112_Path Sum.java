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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)  return false;
        if(root.left==null&&root.right==null&&root.val!=sum)
            return false;
        if(root.left==null&&root.right==null&&root.val==sum)
            return true;
        HashSet<Integer> s = new HashSet<>();
        int sump=root.val;
        DFS(root.left, sump, s);
        DFS(root.right,sump, s);
        if(s.contains(sum)){
            return true;
        }
        else{
            return false;
        }
    }
    private void DFS(TreeNode subRoot, int sump, Set s){
        if(subRoot==null)   return;
        if(subRoot.left==null&&subRoot.right==null){
            sump += subRoot.val;
            s.add(sump);
            return;
        }
        DFS(subRoot.left, sump+subRoot.val,s);
        DFS(subRoot.right, sump+subRoot.val,s);
    }
}