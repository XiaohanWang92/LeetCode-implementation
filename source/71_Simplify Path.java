public class Solution {
    public String simplifyPath(String path) {
        if(path==null||path.length()==0)    return "/";
        Deque<String> stack = new LinkedList<String>();
        String[] dir = path.split("/");
        Set<String> hs = new HashSet<String>(Arrays.asList(".","..",""));
        for(String s : dir){
            if(!hs.contains(s)) stack.push(s);
            else if(s.equals("..")&&!stack.isEmpty()) stack.pop();
        }
        if(stack.isEmpty())   return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/"+stack.removeLast());
        }
        return sb.toString();
    }
}
