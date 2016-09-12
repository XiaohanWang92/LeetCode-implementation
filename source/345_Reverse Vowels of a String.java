public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1)
            return s;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] c = s.toCharArray();
        int low = 0, high = c.length - 1;
        while(high - low > 0) {
            while(high - low > 0 && !vowels.contains(c[low]))
                low++;
            while(high - low > 0 && !vowels.contains(c[high]))
                high--;
            if(high - low > 0 && vowels.contains(c[low]) && vowels.contains(c[high])) {
                char temp = c[low];
                c[low] = c[high];
                c[high] = temp;
                low++;
                high--;
            }
        }
        return String.valueOf(c);
    }
}
