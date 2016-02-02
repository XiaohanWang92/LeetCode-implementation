public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length==0 || s.length ==1)    return;
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length; i++){
            if(s[i] == ' ' || i == s.length-1 ){
                end = (i == s.length-1) ? s.length-1 : i-1;
                reverseWords(s, start, end);
                start = i+1;
            }
        }
        reverseWords(s, 0, s.length-1);
    }
    private void reverseWords(char[] s, int start, int end){
        if(start>=end)  return;
        while(start<end){
            char tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }
}
