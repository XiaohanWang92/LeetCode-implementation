/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursive method
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null)   return results;
        postorderTraversal(results, root);
        return results;
    }
    
    private void postorderTraversal(List<Integer> results, TreeNode root) {
        if(root == null)    return;
        postorderTraversal(results, root.left);
        postorderTraversal(results, root.right);
        results.add(root.val);
    }
}

// Iterative method
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> results = new LinkedList<>();
        if(root == null)    return results;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(stack.size() != 0) {
            TreeNode curr = stack.pop();
            results.addFirst(curr.val);
            if(curr.left != null) {
                stack.push(curr.left);
            }
            if(curr.right != null) {
                stack.push(curr.right);
            }
        }
        return results;
    }
}
