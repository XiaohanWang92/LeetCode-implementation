public class Solution {
    public boolean isHappy(int n) {
        int re, sqSum;
        sqSum=0;
        re=0;
        Set<Integer> test = new HashSet<Integer>();
        while(test.add(n)){
            sqSum=0;
            while(n>0){
            re=n%10;
            sqSum +=re*re;
            n=n/10;
            }
            if(sqSum==1)
                return true;
            else
                n=sqSum;
        }
        return false;
    }
}