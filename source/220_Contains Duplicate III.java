// O(n)
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;

            // Remove lastBucket to let new one come-in without break the window size
            if (i >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}

// O(nlogn + n^2)
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1 || k < 0 || t < 0)  return false;
        Element[] elements = new Element[nums.length];
        for(int i = 0; i < nums.length; i++) {
            elements[i] = new Element(nums[i], i);
        }
        Arrays.sort(elements, new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                return (int)(e1.value - e2.value);
            }
        });
        for(int i = 0; i < elements.length; i++) {
            for(int j = i + 1; j < elements.length && Math.abs(elements[i].value - elements[j].value) <= (long)t; j++) {
                int indexDiff = Math.abs(elements[i].index - elements[j].index);
                if(indexDiff <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Element {
    long value;
    int index;
    public Element(int v, int i) {
        value = v;
        index = i;
    }
}

// O(nlogk)
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 0 || t < 0)
            return false;
        TreeSet<Integer> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            
            // No 'int' for method floor and ceil return null and expect an object rather than primitive type
            Integer floor = values.floor(nums[i] + t);
            Integer ceil = values.ceiling(nums[i] - t);
            
            // Still need to compare, if t = 2, current number is 5, we expect 3 - 7
            // But in tree there is only a -4, in such case -4 satisfies ceiling(3), so it will still be returned
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
                return true;
            values.add(nums[i]);
            if (i >= k) {
                values.remove(nums[i - k]);
            }
        }
        return false;
    }
}
