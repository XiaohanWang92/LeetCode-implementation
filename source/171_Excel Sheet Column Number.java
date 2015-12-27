public class Solution {
    public int titleToNumber(String s) {
        if(s==null||s.equals(""))   return 0;
        int len=s.length();
        int re=0;
        for(int i=0;i<len;i++){
            re=re*26+(int)(s.charAt(i)-'A'+1);//don't think it complicated
            //do it from backward will make thing much complicated
        }
        return re;
    }
}