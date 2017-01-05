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
    public int countNodes(TreeNode root) {
        if(root == null)  return 0;
        int leftH = leftTreeHeight(root);
        int rightH = rightTreeHeight(root);
        if(leftH == rightH) {
            return (1 << leftH) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftTreeHeight(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    private int rightTreeHeight(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.right;
            depth++;
        }
        return depth;
    }
}
