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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result =new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)  return result;
        q.add(root);
        while(!q.isEmpty()){
            int levelSize=q.size();//**
            List<Integer> levelList = new LinkedList<>();
            for(int i=0;i<levelSize;i++){//careful: Line 19: error: ';' expected
                TreeNode tmp=q.poll();
                if(tmp.left!=null)  q.add(tmp.left);
                if(tmp.right!=null) q.add(tmp.right);
                levelList.add(tmp.val);
            }
            result.add(levelList);
        }
        return result;
    }
}
