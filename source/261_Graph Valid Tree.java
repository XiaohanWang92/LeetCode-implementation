public class Solution {
    class Vertex{
        int ID;
        List<Integer> neighbors;
        boolean isVisiting;
        boolean isVisited;
        public Vertex(int i){
            ID = i;
            neighbors = new ArrayList<Integer>();
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(n==1 && (edges == null || edges.length == 0 || edges[0].length == 0))
            return true;
        if(n<1 || edges == null || edges.length == 0 || edges[0].length == 0)
            return false;
        Vertex[] vertices = new Vertex[n];
        for(int i = 0; i<n; i++){
            vertices[i] = new Vertex(i);
        }
        for(int[] edge : edges){
            vertices[edge[0]].neighbors.add(edge[1]);
            vertices[edge[1]].neighbors.add(edge[0]);
        }
        for(Vertex v : vertices){
            if(v.neighbors.size()==0)
                return false;
        }
        boolean isCyclic = findCycle(vertices[0], vertices);
        if(isCyclic)    return false;
        for(Vertex v : vertices){
            if(!v.isVisited)
                return false;
        }
        return true;
    }
    private boolean findCycle(Vertex ver, Vertex[] vertices){
        if(ver.isVisited)   return true;
        if(ver.isVisiting)   return false;
        ver.isVisiting = true;
        for(int id : ver.neighbors){
            if(findCycle(vertices[id], vertices))
                return true;
        }
        ver.isVisiting = false;
        ver.isVisited = true;
        return false;
    }
}
