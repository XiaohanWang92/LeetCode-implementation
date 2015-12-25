public class Solution {
    public String addBinary(String a, String b) {
        if(a==null||a.length()==0)
            return b;
        if(b==null||b.length()==0)
            return a;
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        StringBuffer sbf = new StringBuffer();
        int lenA = charA.length;
        int lenB = charB.length;
        int ida=lenA-1, idb=lenB-1;
        int addition = 0, bit=0;
        while(ida>-1||idb>-1||addition==1){
            int bitA = (ida>-1)? Character.getNumericValue(charA[ida--]):0;
            int bitB = (idb>-1)? Character.getNumericValue(charB[idb--]):0;
            bit = (bitA+bitB+addition)%2;
            addition = (bitA+bitB+addition)>=2? 1:0; //don't use modular!
            sbf.append(bit);//or use sbf.insert(0,bit); no need to reverse
        }
        return sbf.reverse().toString();
    }
}