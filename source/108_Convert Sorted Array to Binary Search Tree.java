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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0)
            return null;
        TreeNode head = treeBuilder(nums, 0, nums.length-1);
        return head;
    }
    
    private TreeNode treeBuilder(int[] nums, int low, int high){
        if(low > high)  return null;
        int mid = low + (high-low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = treeBuilder(nums, low, mid-1);
        node.right = treeBuilder(nums, mid+1, high);
        return node;
    }
}
