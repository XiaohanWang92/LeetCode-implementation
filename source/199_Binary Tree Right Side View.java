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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)    return new LinkedList<Integer>();
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> layer = new LinkedList<>();
        layer.add(root);
        while(!layer.isEmpty()){
            LinkedList<TreeNode> thisLayer = new LinkedList<>();
            int j = layer.size();
            for(int i=0; i<j-1; i++){
                TreeNode t = layer.remove();
                if(t.left!=null)    thisLayer.add(t.left);
                if(t.right!=null)   thisLayer.add(t.right);
            }
            TreeNode last = layer.remove();
            res.add(last.val);
            if(last.left!=null)    thisLayer.add(last.left);
            if(last.right!=null)   thisLayer.add(last.right);
            layer.addAll(thisLayer);
        }
        return res;
    }
}
