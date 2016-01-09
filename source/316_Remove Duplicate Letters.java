public class Solution {
    
    int[] count = new int[26];
    boolean[] isInStack = new boolean[26];
    
    public String removeDuplicateLetters(String s) {
        if(s==null) return "";
        if(s.length()<2)    return s;
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        Deque<Character> stack = new LinkedList<>();
        for(char c :s.toCharArray()){
            count[c-'a']--;
            if(isInStack[c-'a'])   continue;
            while(!stack.isEmpty()&&stack.peek()>c&&count[stack.peek()-'a']!=0){
                char tmp = stack.pop();
                isInStack[tmp-'a']=false;
            }
            stack.push(c);
            isInStack[c-'a']=true;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
