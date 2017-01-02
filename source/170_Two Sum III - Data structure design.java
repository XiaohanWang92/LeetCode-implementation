public class TwoSum {
    private Map<Integer,Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if(map.get(number) != null) {
            map.put(number, 2);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for(int key : map.keySet()) {
            int remain = value - key;
            if(remain != key && map.containsKey(remain))
                return true;
            if(remain == key && map.get(key) == 2)
                return true;
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
