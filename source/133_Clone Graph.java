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
        Deque<UndirectedGraphNode> list = new LinkedList<>();
        map.put(clone.label, clone);
        list.add(node);
        while(list.size() != 0) {
            UndirectedGraphNode curr = list.poll();
            for(UndirectedGraphNode n : curr.neighbors) {
                if(!map.containsKey(n.label)) {
                    UndirectedGraphNode cloneN = new UndirectedGraphNode(n.label);
                    map.put(cloneN.label, cloneN);
                    list.add(n);
                }
                map.get(curr.label).neighbors.add(map.get(n.label));
            }
        }
        return clone;
    }
}
