public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=1;i<n;i++){
            s=this.say(s);
        }
        return s;
    }
    private String say(String s){
        StringBuffer stb = new StringBuffer();
        int id=0;
        while(id<s.length()){
            int count=0;
            char c=s.charAt(id);
            while(id<s.length()&&c==s.charAt(id))
            //in this nested loop also needs to check if index is out of bound
            {
                count++;
                id++;
            }
            stb.append(count);
            stb.append(c);
        }
        return stb.toString();
    }
}