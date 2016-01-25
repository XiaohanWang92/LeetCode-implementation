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
    public List<TreeNode> generateTrees(int n) {
        if(n==0)    return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }
    private List<TreeNode> generateTrees(int s, int e){
        if(s>e){
            List<TreeNode> nullRes = new ArrayList<>();
            nullRes.add(null);
            return nullRes;
        }
        if(s==e){
            TreeNode leaf = new TreeNode(s);
            List<TreeNode> leafRes = new ArrayList<>();
            leafRes.add(leaf);
            return leafRes;
        }
        List<TreeNode> res = new ArrayList<>();
        for(int i = s; i<=e; i++){
            List<TreeNode> leftSub = generateTrees(s, i-1);
            List<TreeNode> rightSub = generateTrees(i+1, e);
            int m = leftSub.size(), n = rightSub.size();
            for(int j=0; j<m; j++){
                for(int k=0; k<n; k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSub.get(j);
                    root.right = rightSub.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
