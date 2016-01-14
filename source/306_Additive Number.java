public class Solution {
    public boolean isAdditiveNumber(String num) {
        
        int len = num.length();
        
        for(int i=1; i<=len/2; i++){
            if(num.charAt(0)=='0' && i>1) continue;
            
            for(int j=i+1; Math.max(j-i,i)<=(len-j) ;j++){
                if(num.charAt(i) == '0' && j-i>1) continue;
                long num1 = Long.parseLong(num.substring(0,i));
                long num2 = Long.parseLong(num.substring(i,j));
                String remain = num.substring(j);
                if(isAdditive(num1, num2, remain))  return true;
            }
        }
        return false;
    }
    
    private boolean isAdditive(long num1, long num2, String remain){
        if(remain.length()==0)  return true;
        Long sum = new Long(num1+num2);
        if(!remain.startsWith(sum.toString()))  return false;
        return isAdditive(num2, sum, remain.substring((sum.toString().length())));
    }
}
