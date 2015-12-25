public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length==0)    return digits;
        int count=digits.length;
        if(digits[digits.length-1]!=9){
            digits[digits.length-1]++;
            return digits;
        }
        else{
            digits[digits.length-1]=0;
            count--;
            int next=digits.length-2;
            while(next>=0&&digits[next]==9){//next(>=0 condition) must reach the most significant digit!
                digits[next]=0;
                next--;
                count--;
            }
            if(count==0){
                int[] newD = new int[digits.length+1];
                newD[0]=1;
                return newD;
            }
            digits[next]++;
            return digits;
        }
    }
}