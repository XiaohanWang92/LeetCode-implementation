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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)  return result;
        q.add(root);
        while(!q.isEmpty()){
            //there is no empty() method in this API class
            int levelSize=q.size();
            List<Integer> level=new LinkedList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode tmp=q.remove();
                if(tmp.left!=null)  q.add(tmp.left);
                if(tmp.right!=null) q.add(tmp.right);
                level.add(tmp.val);
            }
            result.add(level);
        }
        int size=result.size();
        LinkedList<List<Integer>> result2 = new LinkedList<>();
        //be careful here
        for(int i=0;i<size;i++){
            result2.add(result.pollLast());
        }
        return result2;
    }
}
