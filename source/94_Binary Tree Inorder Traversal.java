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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null)    return results;
        inorderWalk(root, results);
        return results;
    }

    private void inorderWalk(TreeNode root, List<Integer> results) {
        if(root == null)  return;
        inorderWalk(root.left, results);
        results.add(root.val);
        inorderWalk(root.right, results);
    }
}

//use stack
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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)    return new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> results = new ArrayList<>();
        TreeNode cursor = root;
        while(cursor != null || stack.size() != 0) {
            while(cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            }
            TreeNode t = stack.pop();
            results.add(t.val);
            cursor = t.right;
        }
        return results;
    }
}
