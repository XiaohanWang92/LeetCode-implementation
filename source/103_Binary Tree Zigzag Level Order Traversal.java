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
        if(root == null)    return res;
        Queue<TreeNode> level = new LinkedList<>();
        boolean flag = true;
        level.offer(root);
        while(!level.isEmpty()){
            int size = level.size();
            LinkedList<Integer> l = new LinkedList<>();
            for(int i=1; i<=size; i++){
                TreeNode node = level.poll();
                if(flag){
                    l.add(node.val);
                }else{
                    l.add(0, node.val);
                }
                if(node.left != null)
                    level.offer(node.left);
                if(node.right != null)
                    level.offer(node.right);
            }
            res.add(l);
            flag = !flag;
        }
        
        return res;
    }
}
