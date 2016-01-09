public class Solution {
    private int startPos;
	private int currMaxLen;
    public String longestPalindrome(String s) {
        if(s==null) return "";
	    if(s.length()<2)    return s;
	    for(int i=0; i<s.length()-1; i++){
	       updatePalin(s, i, i+1);//find even maximum length substring
	       updatePalin(s, i, i);//find odd maximum length substring
	    }
	    return s.substring(startPos, startPos+currMaxLen);
    }
    private void updatePalin(String s, int toLeft, int toRight){
	   while(toLeft>=0&&toRight<s.length()&&s.charAt(toLeft)==s.charAt(toRight)){
	       toLeft--;
	       toRight++;
	   }
	   if(currMaxLen<toRight-toLeft-1){
	       currMaxLen = toRight-toLeft-1;
	       startPos = toLeft+1;
	   }
    }
}
