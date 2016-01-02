public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA=A.length, colA=A[0].length, colB=B[0].length;
        int[][] res = new int[rowA][colB];
        List[] storeA = new List[rowA];
        for(int i=0;i<rowA;i++){
            List<Integer> pair =new ArrayList<>();
            for(int j=0;j<colA;j++){
                if(A[i][j]!=0){
                    pair.add(A[i][j]);
                    pair.add(j);
                }
            }
            storeA[i]=pair;
        }
        for(int i=0;i<rowA;i++){
            List<Integer> check = storeA[i];
            for(int id=0;id<check.size();id=id+2){
                int valA=check.get(id);
                int colNum=check.get(id+1);
                for(int j=0;j<colB;j++){
                    res[i][j] = res[i][j]+valA*B[colNum][j];
                }
            }
        }
        return res;
    }
}
