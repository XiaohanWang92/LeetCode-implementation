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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        Deque<TreeNode> s = new LinkedList<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode invert = s.pop();
            TreeNode left = invert.right;
            TreeNode right = invert.left;
            invert.left = left;
            invert.right = right;

            // this tree level has been done
            if(left != null) {
                s.push(left);
            }
            if(right != null) {
                s.push(right);
            }
        }
        return root;
    }
}
