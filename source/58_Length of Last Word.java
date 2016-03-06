public class Solution {
    public int lengthOfLastWord(String s) {
        String cuts = s.trim();
        int lastSpace = cuts.lastIndexOf(" ");
        return cuts.length()-lastSpace-1;
    }
}
//stupid method, slower
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)    return 0;
        s = s.trim();
        if(s.length() == 0)
            return 0;
        int c = 0, idx = s.length() - 1;
        while(idx >= 0){
            if(s.charAt(idx) == ' ')
                break;
            else
                c++;
            idx--;
        }
        return c;
    }
}
