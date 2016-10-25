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
        if(root == null || (root.left == null && root.right == null))    return;
        TreeLinkNode upperCurLeftmost = root;
        TreeLinkNode lowerHead = null;
        TreeLinkNode lowerPrev = null;
        while(upperCurLeftmost != null) {
            TreeLinkNode upperCur = upperCurLeftmost;
            while(upperCur != null) {
                if(upperCur.left != null) {
                    if(lowerPrev == null) {
                        lowerHead = upperCur.left;
                        lowerPrev = lowerHead;
                    } else {
                        lowerPrev.next = upperCur.left;
                        lowerPrev = upperCur.left;
                    }
                }
                if(upperCur.right != null) {
                    if(lowerPrev == null) {
                        lowerHead = upperCur.right;
                        lowerPrev = lowerHead;
                    } else {
                        lowerPrev.next = upperCur.right;
                        lowerPrev = upperCur.right;
                    }
                }
                upperCur = upperCur.next;
            }
            upperCurLeftmost = lowerHead;
            lowerHead = null;
            lowerPrev = null;
        }
    }
}
