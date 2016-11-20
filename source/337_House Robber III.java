/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //naive approach
public class Solution {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int rob = rob(root, true);
        int norob = rob(root, false);
        return Math.max(rob, norob);
    }

    private int rob(TreeNode root, boolean robThis) {
        if(root == null)
            return 0;
        if(robThis) {
            int leftGet = rob(root.left, false);
            int rightGet = rob(root.right, false);
            return root.val + leftGet + rightGet;
        } else {

            // rob current subtree house or not
            int robLeft = rob(root.left, true);
            int noRobLeft = rob(root.left, false);
            int robRight = rob(root.right, true);
            int noRobRight = rob(root.right, false);

            // 4 combinations
            return Math.max(robLeft, noRobLeft) + Math.max(robRight, noRobRight);
        }
    }
}

//use map to memory overlap
public class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> m = new HashMap<>();
        return rob(root, m);
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> m) {
        if(root == null)
            return 0;
        if(m.containsKey(root))
            return m.get(root);

        //if map doesn't contain any key
        int noRobRoot = rob(root.left, m) + rob(root.right);
        int robRoot = root.val;
        if(root.left != null)
            robRoot += rob(root.left.left, m) + rob(root.left.right, m);
        if(root.right != null)
            robRoot += rob(root.right.left, m) + rob(root.right.right, m);
        int max = Math.max(noRobRoot, robRoot);
        m.put(root, max);
        return max;
    }
}

