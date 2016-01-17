/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private final String COMMA = ",";
    private final String NULL = "N";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    private void serialize(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append(NULL).append(COMMA);
        }else{
            sb.append(root.val).append(COMMA);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0)    return null;
        String[] dataList = data.split(COMMA);
        Deque<String> treeNodeList = new LinkedList<String>(Arrays.asList(dataList));
        return deserialize(treeNodeList);
    }
    private TreeNode deserialize(Deque<String> treeNodeList){
        String node = treeNodeList.remove();
        if(node.equals(NULL))   return null;
        TreeNode newNode = new TreeNode(Integer.parseInt(node));
        newNode.left = deserialize(treeNodeList);
        newNode.right = deserialize(treeNodeList);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
