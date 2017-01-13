public class Solution {
    class CharWithFreq {
        char value;
        int frequency;
        public CharWithFreq(char v, int freq) {
            value = v;
            frequency = freq;
        }
    }
    
    public String frequencySort(String s) {
        if(s == null || s.length() == 0)    return s;
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        List<CharWithFreq> charList = new ArrayList<>();
        for(Character c : countMap.keySet()) {
            charList.add(new CharWithFreq(c, countMap.get(c)));
        }
        Collections.sort(charList, new Comparator<CharWithFreq>() {
            
            @Override
            public int compare(CharWithFreq cwf1, CharWithFreq cwf2) {
                return cwf2.frequency - cwf1.frequency;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(CharWithFreq cwf : charList) {
            for(int i = 1; i <= cwf.frequency; i++) {
                sb.append(cwf.value);
            }
        }
        return sb.toString();
    }
}
