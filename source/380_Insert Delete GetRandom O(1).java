public class RandomizedSet {
    Map<Integer, Integer> indexMap;
    java.util.Random random;
    ArrayList<Integer> setList;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        setList = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new java.util.Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(indexMap.containsKey(val))   return false;
        setList.add(val);
        int index = setList.size() - 1;
        indexMap.put(val, index);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!indexMap.containsKey(val))  return false;
        int index = indexMap.get(val);

        // if removed item is not in the last position, swap with the last one
        if(index != setList.size() - 1) {
            int lastVal = setList.get(setList.size() - 1);
            setList.set(index, lastVal);
            indexMap.put(lastVal, index);
        }
        setList.remove(setList.size() - 1);
        indexMap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {

        // "Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)...."
        return setList.get(random.nextInt(setList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
