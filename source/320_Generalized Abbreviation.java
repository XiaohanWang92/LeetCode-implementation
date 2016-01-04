public class Solution {
    public List<String> generateAbbreviations(String word){
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);
        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }
}
/*a solution better than mine, I'll commit mine after I finish polishing my code*/