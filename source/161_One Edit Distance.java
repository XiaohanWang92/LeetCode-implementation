public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s==null || t==null)  return false;
        if(Math.abs(s.length()-t.length())>1)   return false;
        String longStr = s.length()>t.length()? s : t;
        String shortStr = s.length()>t.length()? t : s;
        int index=0;
        for( ; index<shortStr.length(); index++){
            if(shortStr.charAt(index)==longStr.charAt(index))
                continue;
            else{
                //substitution check
                if(shortStr.substring(index+1).equals(longStr.substring(index+1)))
                    return true;
                //insert or delete check
                else if(shortStr.substring(index).equals(longStr.substring(index+1)))
                    return true;
                else
                    return false;
                }
        }
        if(shortStr.length()==longStr.length())
            return false;
        else
            return true;
    }
}
