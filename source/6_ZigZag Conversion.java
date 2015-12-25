public class Solution {
    public String convert(String s, int numRows) {
        int len=s.length();
        StringBuffer[] sBuffer = new StringBuffer[numRows];
        for(int k=0;k<numRows;k++)
            sBuffer[k]=new StringBuffer();
        int i=0;
        while(i<len){
            for(int j=0;j<numRows&&i<len;j++)
                sBuffer[j].append(s.charAt(i++));
            for(int j=numRows-2;j>=1&&i<len;j--)
            //be careful, if j>=0, output goes wrong
                sBuffer[j].append(s.charAt(i++));
        }
        StringBuffer sSum = new StringBuffer();
        for(int m=0;m<numRows;m++)
            sSum.append(sBuffer[m]);
        return sSum.toString();
    }
}
