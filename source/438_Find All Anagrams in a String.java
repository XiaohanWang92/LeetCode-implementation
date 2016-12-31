public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (s == null || p == null || p.length() > s.length()) return results;
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {

            // current right char exists in map (count of char >= 1) means we find one matching character
            // so we decrease the count
            if (map[s.charAt(right) - 'a'] >= 1) {
                count--;
            }
            
            // when the count is 0, find one anagram
            if (count == 0) {
                results.add(left);
            }
            
            // move right one step, decrease char count anyway
            map[s.charAt(right) - 'a']--;
            right++;
            
            // if window size equals to p length, then we need to move left one step
            // only increase the count if and only if the left character is in p
            // the count >= 0 indicates it was originally in map, because if char count is negative
            // left character is never in p before or this character represents one redundant char in p
            // examples: "cba"/"ba" and "bba"/"ba" (s/p), when left is 0 and right is 2
            if (right - left == p.length()) {
                if (map[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                // reset the char count
                map[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return results;
    }
}

// TLE
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length())    return results;
        Map<Character, Integer> charNumMap = new HashMap<>();
        for(char c : p.toCharArray()) {
            int count = charNumMap.getOrDefault(c, 0);
            count += 1;
            charNumMap.put(c, count);
        }
        char[] sCharArray = s.toCharArray();
        int length = p.length();
        for(int i = 0; i <= sCharArray.length - length; i++) {
            Map<Character, Integer> checkMap = new HashMap<>(charNumMap);
            for(int j = i; j < i + length; j++) {
                if(!checkMap.containsKey(sCharArray[j])) break;
                int count = checkMap.get(sCharArray[j]);
                if(count == 1)  checkMap.remove(sCharArray[j]);
                else    checkMap.put(sCharArray[j], count - 1);
                if(checkMap.size() == 0 && j == i + length - 1) {
                    results.add(i);
                }
            }
        }
        return results;
    }
}
