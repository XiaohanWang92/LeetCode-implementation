/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Avg time complexity O(NlogN), worst case O(N^2)
public class Codec {
    private final String COMMA = ",";
    private final String NULL = "N";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return NULL;
        Deque<TreeNode> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);
        while(stack.size() != 0) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(COMMA);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NULL))   return null;
        String[] nodes = data.split(COMMA);
        Queue<Integer> nodeQueue = new LinkedList<>();
        for(String node : nodes) {
            nodeQueue.offer(Integer.parseInt(node));
        }
        return deserialize(nodeQueue);
    }
    
    private TreeNode deserialize(Queue<Integer> nodeQueue) {
        if(nodeQueue.size() == 0)   return null;
        int rootVal = nodeQueue.poll();
        TreeNode root = new TreeNode(rootVal);
        Queue<Integer> leftTreeQueue = new LinkedList<>();
        while(!nodeQueue.isEmpty() && rootVal > nodeQueue.peek()) {
            leftTreeQueue.offer(nodeQueue.poll());
        }
        root.left = deserialize(leftTreeQueue);
        
        // nodeQueue now represents rightTreeQueue
        root.right = deserialize(nodeQueue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
