/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)  return null;
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new LinkedList<>();
        map.put(clone.label, clone);
        queue.add(node);
        while(queue.size() != 0) {
            UndirectedGraphNode curr = queue.poll();
            for(UndirectedGraphNode n : curr.neighbors) {
                if(!map.containsKey(n.label)) {
                    UndirectedGraphNode cloneN = new UndirectedGraphNode(n.label);
                    map.put(cloneN.label, cloneN);
                    queue.add(n);
                }
                map.get(curr.label).neighbors.add(map.get(n.label));
            }
        }
        return clone;
    }
}
