public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            results.add(x - y);
                        } else if (c == '+') {
                            results.add(x + y);
                        } else if (c == '*') {
                            results.add(x * y);
                        }
                    }
                }
            }
        }
        if (results.size() == 0) results.add(Integer.valueOf(input));
        return results;
    }
}
