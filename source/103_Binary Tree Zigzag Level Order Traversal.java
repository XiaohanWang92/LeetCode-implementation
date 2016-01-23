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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)  return res;
        Deque<TreeNode> currentLayer = new LinkedList<>();
        Deque<TreeNode> nextLayer = new LinkedList<>();
        List<Integer> layerList = new ArrayList<>();
        currentLayer.push(root);
        boolean flag = true;//from left to right?
        while(!currentLayer.isEmpty()){
            TreeNode node = currentLayer.pop();
            if(flag){
                if(node.left!=null) nextLayer.push(node.left);
                if(node.right!=null)    nextLayer.push(node.right);
            }else{
                if(node.right!=null)    nextLayer.push(node.right);
                if(node.left!=null) nextLayer.push(node.left);
            }
            layerList.add(node.val);
            if(currentLayer.isEmpty()){
                res.add(new ArrayList(layerList));
                layerList.clear();
                flag = !flag;
                Deque tmp = currentLayer;
                currentLayer = nextLayer;
                nextLayer = tmp;
            }
        }
        return res;
    }
}
