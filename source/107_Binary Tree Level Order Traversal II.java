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
        if(root == null)    return new ArrayList<List<Integer>>();
        LinkedList<List<Integer>> results = new LinkedList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size() != 0) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 1; i <= size; i++) {
                TreeNode t = q.poll();
                l.add(t.val);
                if(t.left != null)  q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            results.addFirst(l);
        }
        return results;
    }
}
