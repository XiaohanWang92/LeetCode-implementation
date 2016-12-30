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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null)    return results;
        preorder(root, results);
        return results;
    }

    private void preorder(TreeNode root, List<Integer> results) {
        if(root == null)  return;
        results.add(root.val);
        preorder(root.left, results);
        preorder(root.right, results);
    }
}

// solution without recursion
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> results = new ArrayList<>();
        if(root == null)  return results;
        stack.push(root);
        while(stack.size()!=0){
            TreeNode curr = stack.pop();
            if(curr != null) {
                results.add(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return results;
    }
}
