public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length < 1)    return null;
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            str[i] = nums[i] + "";
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        };
        Arrays.sort(str, comparator);
        if(str[str.length - 1].equals("0"))   return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
