public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0)    return "";
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.length() == 0)    return results;
        int index = 0;
        while(index < s.length()) {
            int i = s.indexOf("#" , index);
            int len = Integer.parseInt(s.substring(index, i));
            String decode = s.substring(i + 1, i + 1 + len);
            results.add(decode);
            index = i + 1 + len;
        }
        return results;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
