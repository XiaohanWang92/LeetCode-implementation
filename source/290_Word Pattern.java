public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null&&str==null)    return true;
        String[] word = str.split(" ");
        if(word.length!=pattern.length())   return false;
        HashMap<Character,String> hs = new HashMap<>();
        for(int i=0;i<word.length;i++){
            if(!hs.containsKey(pattern.charAt(i))){
                if(hs.containsValue(word[i])){
                    return false;
                }
                hs.put(pattern.charAt(i),word[i]);
            }
            else{
                if(!word[i].equals(hs.get(pattern.charAt(i)))){
                    return false;
                }
            }
        }
        return true;
    }
}
/* HashMap.containsValue(K,V) has a running time of O(n), so for input with length n,
the running time will becomes O(n^2)
using HashMap.put might be a better choice.
*/
