public class Solution {
    public int bulbSwitch(int n) {
        if(n<1) return 0;
        return (int)Math.floor(Math.sqrt((double)n));
    }
}
