public class Solution {
    public List<String> findStrobogrammatic(int n) {
        if(n == 0)    return new ArrayList<String>();
        if(n == 1)    return new ArrayList<String>(Arrays.asList("0", "8", "1"));
        return findStrobogrammatic(n, n);
    }

    private List<String> findStrobogrammatic(int subsize, int size) {
        if(subsize == 0) {
            List<String> list = new ArrayList<>();
            list.add("");

            // don't add nothing, otherwise we can't enter foreach loop
            return list;
        }
        if(subsize == 1)  return new ArrayList<String>(Arrays.asList("0", "8", "1"));

        // for size from 0 -> size - 1 index, find Strobogrammatic Number 1 -> size-2
        List<String> subList = findStrobogrammatic(subsize - 2, size);
        List<String> results = new ArrayList<>();
        for(String subStrobogrammatic : subList) {

            // if subsize == size, can't add 0, or we may get 0880, it is not a valid number
            if(subsize != size)
                results.add("0" + subStrobogrammatic + "0");
            results.add("8" + subStrobogrammatic + "8");
            results.add("6" + subStrobogrammatic + "9");
            results.add("9" + subStrobogrammatic + "6");
            results.add("1" + subStrobogrammatic + "1");
        }
        return results;
    }
}
