public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length <= 1)
            return;
        swap(s, 0, s.length-1);
        int start = 0, end = 0;
        for(int i=0; i<s.length; i++){
            if(s[i] == ' '){
                end = i-1;
                swap(s, start, end);
                start = i + 1;
            }
        }
        swap(s, start, s.length-1);
    }
    private void swap(char[] s, int low, int high){
        while(low < high){
            char tmp = s[low];
            s[low] = s[high];
            s[high] = tmp;
            low++;
            high--;
        }
    }
}
