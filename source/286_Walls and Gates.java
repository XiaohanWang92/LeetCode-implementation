public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null) return;
        if(rooms.length==0 || rooms[0].length==0)   return;
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j]==0)
                    BFS(rooms, i, j, 0);
            }
        }
    }
    private void BFS(int[][] rooms, int i, int j, int dist){
        //check out of bound first
        if(i<0||i>rooms.length-1)   return;
        if(j<0||j>rooms[0].length-1)    return;
        //this spot is a wall or has already been visted by BFS
        if(rooms[i][j]<dist)    return;
        
        rooms[i][j] = dist;
        BFS(rooms, i-1, j, dist+1);
        BFS(rooms, i, j-1, dist+1);
        BFS(rooms, i+1, j, dist+1);
        BFS(rooms, i, j+1, dist+1);
    }
}
