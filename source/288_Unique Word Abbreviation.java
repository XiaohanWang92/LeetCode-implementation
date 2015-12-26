public class ValidWordAbbr {
    HashMap<String, HashSet<String>> abbrMap = new HashMap<>();
    public String getAbbrStr(String s){
        if(s.length()<=2)   return s;
        return s.substring(0,1)+(s.length()-2)+s.substring(s.length()-1);
    }
    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            if (word == null)
                continue;
            String abbrWord = getAbbrStr(word);
            if (abbrMap.containsKey(abbrWord)) {
                abbrMap.get(abbrWord).add(word);
            }
            else{
                HashSet<String> hs = new HashSet<String> ();
                hs.add(word);
                abbrMap.put(abbrWord, hs);
        }
    }
}

    public boolean isUnique(String word) {
        if (word == null)
                return true;
        String abbrWord = getAbbrStr(word);
        if (abbrMap.containsKey(abbrWord)) {
            if (abbrMap.get(abbrWord).size() > 1)
                return false;
            if (!abbrMap.get(abbrWord).contains(word))
                return false;
        }
        return true;
    }
}
// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");