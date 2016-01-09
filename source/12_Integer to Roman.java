public class Solution {
    public String intToRoman(int num) {
        String[] less10 = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] less100 = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] less1000 = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] less10000 = {"", "M","MM","MMM"};
        return less10000[num/1000]+less1000[(num%1000)/100]+less100[(num%100)/10]+less10[num%10];
    }
}
