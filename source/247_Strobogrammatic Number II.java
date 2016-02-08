public class Solution {
    public List<String> findStrobogrammatic(int n) {
        if(n==0)    return new ArrayList<String>();
        if(n==1)    return new ArrayList<String>(Arrays.asList("0", "8", "1"));
        return findStrobogrammatic(n, n);
    }
    private List<String> findStrobogrammatic(int subsize, int size){
        if(subsize == 0){
            List<String> l = new ArrayList<>();
            l.add("");//don't add nothing, otherwise we can't enter foreach loop
            return l;
        }
        if(subsize == 1)  return new ArrayList<String>(Arrays.asList("0", "8", "1"));
        //for size from 0->size-1 index, find Strobogrammatic Number 1->size-2 (lie in middle)
        List<String> subList = findStrobogrammatic(subsize-2, size);
        List<String> res = new ArrayList<>();
        for(String subStro : subList){
            //if subsize == size, can't add 0, or we may get 0880, it is not valid number
            if(subsize != size)
                res.add("0"+subStro+"0");
            res.add("8"+subStro+"8");
            res.add("6"+subStro+"9");
            res.add("9"+subStro+"6");
            res.add("1"+subStro+"1");
        }
        return res;
    }
}
