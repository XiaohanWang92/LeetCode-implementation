public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prevCandy = 1, numOfDescend = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {

                // if previous one is a consecutive descending
                if (numOfDescend > 0) {
                    total += numOfDescend * (numOfDescend + 1) / 2;

                    // add more candies to previous peak
                    // exp: [9, 7, 5, 4, 3, 4]
                    // first 9 is given 1 candy, there are 4 descending num following 9
                    // they should be given candies 4 (for 7), 3 (for 5), 2 (for 4), 1 (for 3) (in line 10),
                    // and we amend 9 with extra candies: 4 - 1 + 1 = 4
                    // so 9 has candies of 5, enough to provide sufficient yet minimum candies to its descending tails
                    if (numOfDescend >= prevCandy) total += numOfDescend - prevCandy + 1;
                    numOfDescend = 0;
                    prevCandy = 1;
                }

                // after dealing with peak
                prevCandy = ratings[i] == ratings[i - 1] ? 1 : prevCandy + 1;
                total += prevCandy;
            } else {

                // count descending
                numOfDescend++;
            }
        }

        // descend at th tail of array
        if (numOfDescend > 0) {
            total += numOfDescend * (numOfDescend + 1) / 2;
            if (numOfDescend >= prevCandy) total += numOfDescend - prevCandy + 1;
        }
        return total;
    }
}
