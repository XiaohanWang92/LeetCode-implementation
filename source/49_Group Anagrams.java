public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs.length == 0)
            return list;
        Map<String, List<String>> map = new HashMap<>();
        Arrays.sort(strs);
        for(String s : strs){
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            if(map.containsKey(String.valueOf(sc))) {
                map.get(String.valueOf(sc)).add(s);
            } else {
                List<String> l = new ArrayList<String>();
                l.add(s);
                map.put(String.valueOf(sc), l);
            }
        }
        list.addAll(map.values());
        return list;
    }
}
