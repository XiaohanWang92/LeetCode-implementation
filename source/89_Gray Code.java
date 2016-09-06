public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if(n<0) return list;
        list.add(0);
        for(int i = 0; i < n; i++){
            int size = list.size();
            for(int k = size - 1; k >= 0; k--){
                int highBit = 1 << i;
                int oringinalBit = list.get(k);
                list.add(oringinalBit | highBit);
            }
        }
        return list;
    }
}
// another method
public class Solution {
    public List<Integer> grayCode(int n) {
        if(n <= 0)
            return new LinkedList<Integer>(Arrays.asList(0));
        LinkedList<Integer> result = new LinkedList<>(Arrays.asList(0, 1));
        for(int i = 2; i <= n; i++){
            List<Integer> newGrayCodes = new ArrayList<>(result);
            while(!result.isEmpty()) {
                int currentCode = result.pollLast();
                currentCode += 1 << (i - 1);
                newGrayCodes.add(currentCode);
            }
            result.addAll(newGrayCodes);
        }
        return result;
    }
}
