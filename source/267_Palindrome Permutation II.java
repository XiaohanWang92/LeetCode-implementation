public class Solution {
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++)
            map.put(s.charAt(i), map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) + 1 : 1);
        List<String> list = new ArrayList<>();
        boolean centerfound = n % 2 == 0 ? true : false;
        StringBuilder sb = new StringBuilder();
        char center = ' ';
        for(Map.Entry<Character, Integer> ent: map.entrySet()){
            if(ent.getValue() % 2 != 0 && !centerfound){
                centerfound = true;
                center = ent.getKey();
            }
            else if(ent.getValue() % 2 != 0) return list;
            for(int j = 0; j < ent.getValue() / 2; j++)
                sb.append(ent.getKey());
        }
        if(n % 2 != 0)  sb.append(center);
        generatePalinHelper(list, sb, 0, n/2);
        return list;
    }
    public void generatePalinHelper(List<String> list, StringBuilder sb, int start, int len){
        if(start == len){
            StringBuilder tempsb = new StringBuilder(sb);
            for(int i = len - 1; i >= 0; i--)   tempsb.append(tempsb.charAt(i));
            list.add(tempsb.toString());
        }
        for(int i = start; i < len; i++){
            if(i != start && sb.charAt(i) == sb.charAt(start))    continue;
            swap(sb, i, start);
            generatePalinHelper(list, sb, start + 1, len);
            swap(sb, i, start);
        }
    }
    public void swap(StringBuilder sb, int i, int j){
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ch);
    }
}
