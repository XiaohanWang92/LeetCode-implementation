public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)  return new ArrayList<Integer>();
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;
        for(int n : nums) {
           if(n == candidate1)    count1++;
           else if(n == candidate2)   count2++;
           else if(count1 == 0) {
               candidate1 = n;
               count1++;
           } else if (count2 ==0) {
               candidate2 = n;
               count2++;
           } else {
               count1--;
               count2--;
           }
        }
        count1 = 0;
        count2 = 0;
        for(int n : nums) {
            if(n == candidate1)   count1++;
            else if(n == candidate2)   count2++;
        }
        List<Integer> list = new ArrayList<>();
        if(count1 > nums.length / 3)    list.add(candidate1);
        if(count2 > nums.length / 3)    list.add(candidate2);
        return list;
    }
}
