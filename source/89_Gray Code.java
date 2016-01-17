public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if(n<0) return list;
        list.add(0);
        for(int i=0; i<n; i++){
            int size = list.size();
            for(int k = size-1; k>=0; k--){
                int highbit = 1<<i;
                int oringbit = list.get(k);
                list.add(oringbit | highbit);
            }
        }
        return list;
    }
}
