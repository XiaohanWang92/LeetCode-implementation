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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// wrong answer, need to use level order traversal!!!!

// Input:
// [3,9,8,4,0,1,7,null,null,null,2,5]
// Output:
// [[4],[9,5],[3,0,1],[2,8],[7]]
// Expected:
// [[4],[9,5],[3,0,1],[8,2],[7]]

// 2 is on left tree but 8 is on right tree
// so inorder traversal make 2 is behind 8, but this question is asking for 8 is ahead 2

public class Solution {
    
    private int minId = Integer.MAX_VALUE;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> idMap = new HashMap<>();
        findVerticalIdInorderTraversal(idMap, 0, root);
        int i = minId;
        List<List<Integer>> results = new ArrayList<>();
        while(idMap.containsKey(i)) {
            results.add(idMap.get(i));
            i++;
        }
        return results;
    }
    
    private void findVerticalIdInorderTraversal(Map<Integer, List<Integer>> idMap, int id, TreeNode node) {
        if(idMap.containsKey(id)) {
            idMap.get(id).add(node.val);
        } else {
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            idMap.put(id, l);
            minId = Math.min(minId, id);
        }
        if(node.left != null) {
            findVerticalIdInorderTraversal(idMap, id - 1, node.left);
        }
        if(node.right != null) {
            findVerticalIdInorderTraversal(idMap, id + 1, node.right);
        }
    }
}

/*
 * Right solution.
 */
public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> results = new ArrayList<>();
    if(root == null) return results;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Queue<TreeNode> nodeQ = new LinkedList<>();
    Queue<Integer> nodeIdQ = new LinkedList<>();
    nodeQ.add(root); 
    nodeIdQ.add(0);

    // root id is 0
    int min = 0, max = 0;
    while(!nodeQ.isEmpty()) {
        TreeNode node = nodeQ.poll();
        int id = nodeIdQ.poll();
        if(!map.containsKey(id)) {
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            map.put(id, l);
        } else {
            map.get(id).add(node.val);
        }
        if(node.left != null) {
            nodeQ.add(node.left);
            int newId = id - 1;
            nodeIdQ.add(newId);
            if(newId < min) min = newId;
        }
        if(node.right != null) {
            nodeQ.add(node.right);
            int newId = id + 1;
            nodeIdQ.add(newId);
            if(newId > max) max = newId;
        }
    }

    for(int i = min; i <= max; i++) {
        results.add(map.get(i));
    }
    return results;
}
