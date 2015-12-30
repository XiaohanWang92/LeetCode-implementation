public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num==null)   return false;
        if(num.equals(""))  return true;
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('1','1');
        map.put('0','0');
        map.put('6','9');
        map.put('9','6');
        map.put('8','8');
        int len=num.length();
        for(int i=0,j=len-1;i<=j;i++,j--){
            if(!map.containsKey(num.charAt(i)))
                return false;
            if(map.get(num.charAt(i))!=num.charAt(j))
                return false;
        }
        return true;
    }
}
