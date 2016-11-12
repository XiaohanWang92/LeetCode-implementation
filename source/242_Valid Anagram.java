public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)    return false;
        if(s.length() != t.length())  return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int k = map.get(s.charAt(i));
                map.put(s.charAt(i), k + 1);
            }
        }
        for(int i = 0; i < t.length(); i++) {
            if(!map.containsKey(t.charAt(i)))    return false;
            int k = map.get(t.charAt(i));
            map.put(t.charAt(i), k - 1);
        }
        for(Character k : map.keySet()) {
            if(map.get(k) != 0)   return false;
        }
        return true;
    }
}
/*above solution deals with Unicode, for 26 lowercase english alphabets, there is a quicker solution
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)    return false;
        if(s.length() != t.length())  return false;
        int[] alphabet = new int[26];//default zero
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
*/
// Or use hash set
