/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof=false;//End Of File
        int charNumTotal=0;
        while(!eof&&charNumTotal<n){
            char[] buf4=new char[4];
            int readNum=read4(buf4);
            if(readNum<4){
                eof=true;
            }
            //deal with how many input char we should really put in
            int input=Math.min(n-charNumTotal,readNum);
            for(int i=0;i<input;i++){
                buf[charNumTotal+i]=buf4[i];
            }
            charNumTotal +=input;
        }
        return charNumTotal;
    }
}
