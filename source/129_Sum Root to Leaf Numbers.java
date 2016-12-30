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
    public int sumNumbers(TreeNode root) {
        if(root == null)  return 0;
        if(root.left == null && root.right == null) return root.val;
        List<Integer> pathNum = new ArrayList<>();
        if(root.left != null)
            getNum(pathNum, root.left, root.val);
        if(root.right != null)
            getNum(pathNum, root.right, root.val);
        int sum = 0;
        for(int i : pathNum) {
            sum += i;
        }
        return sum;
    }

    private void getNum(List<Integer> pathNum, TreeNode root, int prev) {
        if(root.left == null && root.right == null) {
            pathNum.add(prev * 10 + root.val);
            return;
        }
        if(root.left != null)
            getNum(pathNum, root.left, prev * 10 + root.val);
        if(root.right != null)
            getNum(pathNum, root.right, prev * 10 + root.val);
    }
}
