public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] node = new int[n];
        for(int i=0;i<n;i++){
            node[i]=i;
        }
        for(int[] edge:edges){
            int root1=find(edge[0], node);
            int root2=find(edge[1], node);
            if(root1!=root2){
                node[root2]=root1;//union
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(node[i]==i)  count++;
        }
        return count;
    }
    private int find(int vertex, int[] node){
        if(node[vertex]==vertex)    return vertex;
        node[vertex]=node[node[vertex]];//path compression
        return find(node[vertex], node);
    }
}
