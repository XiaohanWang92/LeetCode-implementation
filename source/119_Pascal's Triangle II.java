public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if(rowIndex < 0) return row;
        row.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = i - 1; j >= 1; j--) {
                int k = row.get(j) + row.get(j - 1);
                row.set(j, k);
            }
            row.add(1);//append last element
        }
        return row;
    }
}
