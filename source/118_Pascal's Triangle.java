public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(numRows<=0)  return result;
        for(int i=1;i<=numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=1;j<=i;j++){//i row has j=i elements
                if(j==1||j==i){
                    row.add(1);
                }
                else{
                    int k=result.get(i-1-1).get(j-1-1)+result.get(i-1-1).get(j-1);
                    //be careful with index and size conversion
                    row.add(k);
                }
            }
            result.add(row);
        }
        return result;
    }
}