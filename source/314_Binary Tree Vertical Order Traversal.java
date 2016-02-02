/*
wrong solution, ignore some facts that each list should have a vertical order
*/
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
    private int minID = Integer.MAX_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> hashmap = new HashMap<>();
        if(root==null)  return new ArrayList(hashmap.values());
        verticalID(hashmap, 0, root);
        int i = minID;
        List<List<Integer>> res = new ArrayList<>();
        while(hashmap.containsKey(i)){
            res.add(hashmap.get(i++));
        }
        return res;
    }
    private void verticalID(Map<Integer, List<Integer>> hashmap, int ID, TreeNode root){
        if(hashmap.containsKey(ID)){
            List<Integer> list = hashmap.get(ID);
            minID = Math.min(ID, minID);
            list.add(root.val);
        }else{
            List<Integer> newlist = new ArrayList<>();
            minID = Math.min(ID, minID);
            newlist.add(root.val);
            hashmap.put(ID, newlist);
        }
        if(root.left!=null)
            verticalID(hashmap, ID-1, root.left);
        if(root.right!=null)
            verticalID(hashmap, ID+1, root.right);
    }
}

/*
impressive right solution
*/
public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) return res;

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();

    q.add(root); 
    cols.add(0);

    int min = 0, max = 0;
    while(!q.isEmpty()) {
        TreeNode node = q.poll();
        int col = cols.poll();
        if(!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
        map.get(col).add(node.val);

        if(node.left != null) {
            q.add(node.left); 
            cols.add(col - 1);
            if(col <= min) min = col - 1;
        }
        if(node.right != null) {
            q.add(node.right);
            cols.add(col + 1);
            if(col >= max) max = col + 1;
        }
    }

    for(int i = min; i <= max; i++) {
        res.add(map.get(i));
    }

    return res;
}