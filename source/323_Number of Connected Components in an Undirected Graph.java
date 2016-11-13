public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for(int i = 0; i < n; i++) {
            root[i] = i;
        }
        for(int[] edge : edges) {
            int root1 = find(edge[0], root);
            int root2 = find(edge[1], root);
            if(root1 != root2) {

                // union
                root[root2] = root1;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(root[i] == i)  count++;
        }
        return count;
    }

    private int find(int vertex, int[] root) {
        if(root[vertex] == vertex)    return vertex;
        root[vertex] = root[root[vertex]];
        return find(root[vertex], root);
    }
}
