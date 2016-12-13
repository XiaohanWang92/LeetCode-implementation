/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low + 1 < high) {
            int mid = (high - low) / 2 + low;
            if(guess(mid) == 0) return mid;
            else if(guess(mid) == -1)   high = mid - 1;
            else if(guess(mid) == 1)    low = mid + 1;
        }
        if(guess(low) == 0) return low;
        else return high;
    }
}
