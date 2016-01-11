public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList();
        int len = s.length();
        if(len<4)   return res;
        for(int i=0; i<4 && i<len-2; i++){
            for(int j=i; j<i+4 && j<len-1; j++){
                for(int k=j; k<j+4 && k<len; k++){
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if(isValid(s1)&&isValid(s2)&&isValid(s3)&&isValid(s4))
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                }
            }
        }
        return res;
    }
    private boolean isValid(String sub){
        if(sub.length()<=0 || sub.length()>3) return false;
        if(sub.length()>1 && sub.charAt(0)=='0')  return false;
        if(sub.length()==3 && Integer.parseInt(sub)>255)  return false;
        return true;
    }
}
