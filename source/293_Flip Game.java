public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> nextMove = new ArrayList<>();
        if(s == null || s.length() <= 1)  return nextMove;

        // Check first two
        if(s.charAt(0) == s.charAt(1) && s.charAt(0) == '+')
            nextMove.add("--" + s.substring(2));
        if(s.length() == 2)   return nextMove;
        for(int i = 2; i < s.length() - 1; i++) {
            if(s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == '+')
                nextMove.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
        }

        // Check last two
        if(s.charAt(s.length() - 2) == s.charAt(s.length() - 1) && s.charAt(s.length() - 1) == '+')
            nextMove.add(s.substring(0, s.length() - 2) + "--");
        return nextMove;
    }
}
