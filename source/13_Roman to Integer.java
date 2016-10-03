public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.equals(""))
            return 0;
        HashMap<Character,Integer> toInt = new HashMap<Character, Integer>();
        toInt.put('I', 1);
        toInt.put('V', 5);
        toInt.put('X', 10);
        toInt.put('L', 50);
        toInt.put('C', 100);
        toInt.put('D', 500);
        toInt.put('M', 1000);
        int result = toInt.get(s.charAt(s.length() - 1));
        int check = result;
        for(int i = s.length() - 2; i >= 0; i--) {
            int k = toInt.get(s.charAt(i));
            if(k >= check) {
                result += k;
                check = k;
            } else {
                result -= k;
                check = k;
            }
        }
        return result;
    }
}
