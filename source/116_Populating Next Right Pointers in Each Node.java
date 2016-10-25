/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        TreeLinkNode level = root;
        TreeLinkNode curr = root;
        while(level != null) {
            curr = level;
            while(curr != null) {
                if(curr.left != null)
                    curr.left.next = curr.right;
                if(curr.right != null && curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
    }
}
