/*negative number and multiple of 10 (like 200 110 and so on) are not palindrome except for 0*/
public class Solution {
    public boolean isPalindrome(int x) {
        int half=0;
        if(x<0||(x%10==0&&x!=0))
            return false;
        if(x<10)
            return true;
        while(x>half){
            half = half*10+x%10;
            x /= 10;
        }
        return (x==half||x==half/10);
    }
}