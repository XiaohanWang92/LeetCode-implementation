public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if(strs.length==0||strs==null)
            return "";
        Arrays.sort(strs);//running time: nlg(n)
        char[] first=strs[0].toCharArray();
        char[] last=strs[strs.length-1].toCharArray();
        for(int i=0;i<first.length;i++){
            if(last.length>i&&(first[i]==last[i]))
                prefix.append(first[i]);
            else
                return prefix.toString();
	//as soon as there is one mismatch, return common prefix
        }
        return prefix.toString();
    }
}