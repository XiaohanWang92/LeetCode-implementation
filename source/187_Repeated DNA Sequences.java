public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> table = new HashSet<>();
        List<String> res = new ArrayList<>();
        if(s==null || s.length()==0)    return res;
        int len = s.length();
        for(int i=0; i<=len-10; i++){
            String sub = s.substring(i, i+10);
            if(table.contains(sub)){
                if(!res.contains(sub))
                    res.add(sub);
            }else{
                table.add(sub);
            }
        }
        return res;
    }
}
