public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] index =  new int[2];
        if(numbers == null || numbers.length < 2) return index;
        int index1 = 0;
        int index2 = numbers.length - 1;
        while(index1 < index2) {
            int sum = numbers[index1] + numbers[index2];
            if(sum == target) {
                index[0] = index1 + 1;
                index[1] = index2 + 1;
                break;
            } else if(sum > target) {
                index2--;
            } else {
                index1++;
            }
        }
        return index;
    }
}
