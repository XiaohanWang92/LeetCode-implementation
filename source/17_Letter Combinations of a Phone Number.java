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
