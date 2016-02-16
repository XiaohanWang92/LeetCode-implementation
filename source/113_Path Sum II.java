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
        if(root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        pathSum(root, 0, sum, path, res);
        return res;
    }
    private void pathSum(TreeNode root, int currSum, int sum, List<Integer> path, List<List<Integer>> res){
        if(root.val+currSum == sum && root.left == null && root.right == null){
            path.add(root.val);
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        if(root.left != null){
            path.add(root.val);
            pathSum(root.left, currSum+root.val, sum, path, res);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            path.add(root.val);
            pathSum(root.right, currSum+root.val, sum, path, res);
            path.remove(path.size()-1);
        }
    }
}
