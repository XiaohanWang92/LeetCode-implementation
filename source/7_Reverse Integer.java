public class Solution {
    public int reverse(int x) {
        int temp=x;
        int rev=0;
        int remain=0;
        int check=0;
        if(x==0)
            return x;
        if(x<0)
            temp *= -1;
        while(temp>0){
            remain=temp%10;
            rev = 10*rev+remain;
            while(check!=(rev-remain)/10){
                return 0;
            }
	be careful about overflow!
            check=rev;
            temp /= 10;
        }
        if(x<0)
         return rev*(-1);
        return rev;
    }
}