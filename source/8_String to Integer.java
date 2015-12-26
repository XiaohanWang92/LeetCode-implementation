public class Solution {
    public int myAtoi(String str) {
	        if(str==null)   return 0;
	        String strTrim = str.trim();//cut whitespace
	        if(strTrim.equals(""))  return 0;
	        boolean isPos = true;
	        if(strTrim.charAt(0) == '-'){
	            isPos =false;
	        }
	        int sum=0;
	        int id=0;
	        if(strTrim.charAt(0) == '+' || strTrim.charAt(0) == '-'){
	            id++;
	        }
	        while(id<strTrim.length()&&Character.getNumericValue(strTrim.charAt(id))>=0&&Character.getNumericValue(strTrim.charAt(id))<=9){
	            int digit = Character.getNumericValue(strTrim.charAt(id));
	            if(Integer.MAX_VALUE/10 < sum || Integer.MAX_VALUE/10 == sum && Integer.MAX_VALUE %10 < digit)
	                return isPos? Integer.MAX_VALUE : Integer.MIN_VALUE;
	            sum = 10*sum+digit;
	            id++;
	        }
	        if(!isPos)  sum *= -1;
	        return sum;
    }
}