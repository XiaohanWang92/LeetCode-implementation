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
/use ArrayList, even doesn't speed up/
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        List<TreeNode> layer = new ArrayList<>();
        layer.add(root);
        while(!layer.isEmpty()){
            List<TreeNode> nextLayer = new ArrayList<>();
            int size = layer.size();
            for(int i = 0; i <= size-2; i++){
                TreeNode node = layer.get(i);
                if(node.left != null)
                    nextLayer.add(node.left);
                if(node.right != null)
                    nextLayer.add(node.right);
            }
            TreeNode lastOne = layer.get(size-1);
            res.add(lastOne.val);
            if(lastOne.left != null)
                nextLayer.add(lastOne.left);
            if(lastOne.right != null)
                nextLayer.add(lastOne.right);
            layer.clear();
            layer.addAll(nextLayer);
        }
        return res;
    }
}
