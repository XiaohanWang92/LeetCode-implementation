public class Solution {
    public String countAndSay(int n) {
        if(n < 0)   return "";
        if(n == 0)  return "1";
        String s = "1";
        for(int i = 2; i <= n; i++){
            s = say(s);
        }
        return s;
    }
    private String say(String s){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < s.length()){
            char c = s.charAt(idx);
            int count = 1;
            while(idx+1 < s.length() && s.charAt(idx+1) == c){
                count++;
                idx++;
            }
            sb.append(count).append(c);
            idx++;
        }
        return sb.toString();
    }
}
