public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0)  return new ArrayList<String>();
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = digits.charAt(i) - '0';
            int j = 0;
            int size = ans.size();
            while(j<size){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
                j++;
            }
        }
        return ans;
    }
}
//slower but more readable method
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return res;
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('1', new ArrayList<Character>());
        map.put('0', new ArrayList<Character>());
        map.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));
        List<Character> first = map.get(digits.charAt(0));
        for(char c : first)
            res.add(""+c);
        for(int i = 1; i < digits.length(); i++){
            List<Character> letter = map.get(digits.charAt(i));
            int size = res.size();
            List<String> next = new ArrayList<>();
            for(int j = 0; j < size; j++){
                String s = res.get(j);
                for(char lc : letter)
                    next.add(s + lc);
            }
            res.clear();
            res.addAll(next);
        }
        return res;
    }
}
