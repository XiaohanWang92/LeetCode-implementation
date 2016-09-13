public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int key : nums) {
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        }
        for(Integer key : frequency.keySet()) {
            int occurrence = frequency.get(key);
            if(bucket[occurrence] == null) {
                bucket[occurrence] = new ArrayList<Integer>();
            }
            bucket[occurrence].add(key);
        }
        List<Integer> results = new ArrayList<Integer>();
        for(int i = nums.length; k != 0 && i > 0; i--) {
            if(bucket[i] != null && bucket[i].size() != 0) {
                int size = bucket[i].size();
                if(k >= size) {
                    results.addAll(bucket[i]);
                    k -= size;
                } else {
                    results.addAll(bucket[i].subList(0, k));
                    k = 0;
                }
            }
        }
        return results;
    }
}
