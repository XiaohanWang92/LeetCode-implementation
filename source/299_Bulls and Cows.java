public class Solution {
    public String getHint(String secret, String guess) {
        if(guess.equals(secret))    return secret.length()+"A0B";//don't know length of number!
        int bull=0;
        int cow=0;
        int[] appear = new int[10];
        for(int i=0;i<secret.length();i++){
            int sDigit=(int)(secret.charAt(i)-'0');
            int gDigit=(int)(guess.charAt(i)-'0');
            if(sDigit==gDigit){
                bull++;
            }
            else{
                if(appear[sDigit]<0){
                    cow++;
                }
                if(appear[gDigit]>0){
                    cow++;
                }
                appear[sDigit]++;
                appear[gDigit]--;
            }
        }
        return bull+"A"+cow+"B";
    }
}