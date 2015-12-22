public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse=0;
        for(int i=0;i<32;i++){
            reverse = reverse+(n&1);//logic AND operation
            n = n>>>1;//reverse bits, not integer so don't need taking care of highest sign bit
            if(i<31){
                reverse = reverse<<1;//the last digit can't be shifted
            }
        }
        return reverse;
    }
}