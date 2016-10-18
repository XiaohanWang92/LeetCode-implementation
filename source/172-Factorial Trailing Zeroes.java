public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
/*solution II:
public int trailingZeroes(int n) {
    int power = 1;
    int c = 0;
    int f = (int) (n/(Math.pow(5, power)));

    while(f > 0){
        c += f;
        f = (int) (n/(Math.pow(5, ++power)));
    }

    return c;
}
*/
