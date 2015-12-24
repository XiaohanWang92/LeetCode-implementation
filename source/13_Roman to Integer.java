public class Solution {
    public int romanToInt(String s) {
        if(s==null||s.equals(""))
            return 0;
        HashMap<Character,Integer> toInt = new HashMap<Character, Integer>();
        toInt.put('I',1);
        toInt.put('V',5);
        toInt.put('X',10);
        toInt.put('L',50);
        toInt.put('C',100);
        toInt.put('D',500);
        toInt.put('M',1000);
        int re = toInt.get(s.charAt(s.length()-1));
        int check = re;
        for(int i=s.length()-2;i>=0;i--){
            int k=toInt.get(s.charAt(i));
            if(k>=check){
                re +=k;
                check=k;
            }
            else{
                re -=k;
                check=k;
            }
        }
        return re;
    }
}