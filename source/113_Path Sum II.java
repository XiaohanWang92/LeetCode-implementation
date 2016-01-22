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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root==null)  return res;
        DFS(res, path, sum, root);
        return res;
    }
    private void DFS(List<List<Integer>> res, List<Integer> path, int sum, TreeNode root){
//        if(sum-root.val <0)   return;
        if(sum-root.val ==0){
            if(root.left==null && root.right==null){
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
                return;
            }
        }
        if(root.left!=null){
            path.add(root.val);
            DFS(res, path, sum-root.val, root.left);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            path.add(root.val);
            DFS(res, path, sum-root.val, root.right);
            path.remove(path.size()-1);
        }
    }
}
