//don't need hash map actually, convert unicode character when insert is ok
public class Solution {
    public String convertToTitle(int n) {
        if(n<=0)    return "";
        HashMap<Integer, Character> hs = new HashMap<>();
        for(int i=0;i<26;i++){
            hs.put(i,((char)(i+65)));
        }
        StringBuffer stb = new StringBuffer();
        int temp=n;
        while(temp>0){
            temp--;//*
            int re = temp%26;
            char c = hs.get(re);
            stb.insert(0,c);
            temp=temp/26;//*
        }
        return stb.toString();
    }
}