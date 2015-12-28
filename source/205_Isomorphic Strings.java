public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if((s==null&&t==null)||(s==""&&t==""))    return true;
        HashMap<Character,Character> hs = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hs.containsKey(s.charAt(i))){
                if(hs.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            else{
                if(hs.containsValue(t.charAt(i))){
                    return false;
                }
                hs.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}