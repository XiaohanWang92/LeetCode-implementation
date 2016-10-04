/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    
    private char[] readBuffer = new char[4];
    private int readBufferOffset = 0;
    private int remainInReadBuffer = 0;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int readNum = 0;
        while(readNum < n) {
            
            // previously when using read4, there are remianing chars which have been read out but not written in buf
            // no need to consider the offset of buf, each time buf can be written from beginning
            if(remainInReadBuffer != 0) {
                while(readNum < n && remainInReadBuffer != 0) {
                    buf[readNum++] = readBuffer[readBufferOffset++];
                    remainInReadBuffer--;
                }
                
            // if remainInReadBuffer is empty, we call read4 to get more
            } else {
                remainInReadBuffer  = read4(readBuffer);
                if(remainInReadBuffer == 0) break;
                while(readNum < n && remainInReadBuffer != 0) {
                    buf[readNum++] = readBuffer[readBufferOffset++];
                    remainInReadBuffer--;
                }
            }
            if(remainInReadBuffer == 0) {
                readBufferOffset = 0;
            }
        }
        return readNum;
    }
}
