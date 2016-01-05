public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res =  new ArrayList<>();
        backTrack(res,"",0,0,word);
        return res;
    }
    private void backTrack(List<String> res, String currentS, int pos, int abbrCount, String word){
        if(pos!=word.length()){
            backTrack(res, currentS, pos+1, abbrCount+1, word);//pass current character
            backTrack(res, currentS+(abbrCount==0?"":abbrCount)+word.charAt(pos), pos+1, 0, word);//add abbr and reset abbrCount
        }else{//pos==word.length, at the end of word
            if(abbrCount!=0){
                currentS = currentS+abbrCount;//we need append abbr to the tail
            }
            res.add(currentS);
        }
    }
}