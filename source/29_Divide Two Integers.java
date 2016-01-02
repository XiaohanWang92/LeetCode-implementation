public class Solution {
    public int divide(int dividend, int divisor) {
        int sign=1;
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0))    sign=-1;
        long dvdl=Math.abs((long)dividend);//integer abs(-2^31)=2^31 overflow to -2^31
        long dvsl=Math.abs((long)divisor);//integer abs(-2^31)=2^31 overflow to -2^31
        if(dvsl==0)  return Integer.MAX_VALUE;//2^31-1
        if(dvdl<dvsl||dvdl==0) return 0;
        long res=divideLong(dvdl,dvsl);
        if(res>Integer.MAX_VALUE){//-1 wants to devide MIN_VALUE......
            return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return (int)(sign*res);
    }
    private long divideLong(long dvdl,long dvsl){
        if(dvdl<dvsl)   return 0;
        long multiples=1;
        long doubling = dvsl;
        while((doubling+doubling)<=dvdl){//use if hear will use out of stack!!!!
            doubling +=doubling;
            multiples +=multiples;
        }
        return multiples+divideLong(dvdl-doubling, dvsl);
    }
}
