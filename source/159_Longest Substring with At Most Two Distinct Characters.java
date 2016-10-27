public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)    return 0;
        Map<Character, Integer> occurrenceMap = new HashMap<>();
        int left = 0;
        int num = 0;
        int result = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(!occurrenceMap.containsKey(c)) {
                occurrenceMap.put(c, 1);
                num++;
            } else {
                occurrenceMap.put(c, occurrenceMap.get(c) + 1);
            }
            while(num > 2) {
                char leftC = s.charAt(left);
                int leftCharOccurrence = occurrenceMap.get(leftC);
                leftCharOccurrence--;
                if(leftCharOccurrence == 0) {
                    occurrenceMap.remove(leftC);
                    num--;
                } else {
                    occurrenceMap.put(leftC, leftCharOccurrence);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
