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
        if(root == null)    return new ArrayList<List<Integer>>();
        List<List<Integer>> results = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = true;
        while(q.size() != 0) {
            int size = q.size();
            LinkedList<Integer> l = new LinkedList<>();
            for(int i = 1; i <= size; i++) {
                TreeNode t = q.poll();
                if(reverse) {
                    l.addLast(t.val);
                } else {
                    l.addFirst(t.val);
                }
                if(t.left != null)  q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            results.add(l);
            reverse = !reverse;
        }
        return results;
    }
}
