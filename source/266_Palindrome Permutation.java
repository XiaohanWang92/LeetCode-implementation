public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null) return false;
        if(s.equals("") || s.length() == 1) return true;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i)))   set.remove(s.charAt(i));
            else    set.add(s.charAt(i));
        }
        return set.size() == 0 || set.size() == 1;
    }
}
