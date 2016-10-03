public class Solution {

    private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0)  return "Zero";
        int digit = 0;
        String word = "";
        while(num > 0) {
            if(num % 1000 != 0) {
                word = generator(num % 1000) + thousands[digit] + " " + word;
            }
            digit++;
            num /= 1000;
        }
       return word.trim();//we will get a " " tail 
    }
    private String generator(int num) {
        if(num == 0)  return "";
        else if(num < 20) {
            return lessThan20[num] + " ";
        } else if(num < 100) {
            return tens[num / 10] + " " + generator(num % 10);
        } else {
            return lessThan20[num / 100] + " Hundred " + generator(num % 100);// spaces here
        }
    }
}
