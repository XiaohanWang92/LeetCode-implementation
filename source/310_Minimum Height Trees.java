public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaf = new ArrayList<>();
        if(n < 2) {
            leaf.add(0);
            return leaf;
        }
        List<HashSet<Integer>> vertex = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            vertex.add(new HashSet<Integer>());
        }
        for(int[] edge : edges) {
            vertex.get(edge[0]).add(edge[1]);
            vertex.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < n; i++) {
            if(vertex.get(i).size() == 1)
                leaf.add(i);
        }
        while(n > 2) {
            n -= leaf.size();
            List<Integer> nextLeaf = new ArrayList<>();
            for(int label : leaf) {

                // Only get single one
                int next = vertex.get(label).iterator().next();
                HashSet s = vertex.get(next);
                s.remove(label);
                if(s.size() == 1)
                    nextLeaf.add(next);
            }
            leaf = nextLeaf;
        }
        return leaf;
    }
}
