public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null)   return 0;
        int[] citNum = new int[citations.length + 1];
        for(int i : citations) {
            if(i > citations.length)
                citNum[citations.length]++;
            else
                citNum[i]++;
        }
        int paperSum = 0;
        for(int h = citations.length; h >= 0; h--) {
            paperSum += citNum[h];
            if(h <= paperSum)
                return h;
        }
        return 0;
    }
}
