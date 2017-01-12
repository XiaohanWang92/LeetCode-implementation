public class Solution {
    public int thirdMax(int[] nums) {
        Integer max = null, secondMax = null, thirdMax = null;
        for(int num : nums) {
            if((max != null && max == num) ||
               (secondMax != null && secondMax == num) ||
               (thirdMax != null && thirdMax == null)) {
                continue;
            }
            if(max == null || max < num) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
                continue;
            }
            if((secondMax == null && num < max) ||
               (secondMax != null && num < max && num > secondMax)) {
                thirdMax = secondMax;
                secondMax = num;
                continue;
            }
            if((thirdMax == null && num < secondMax) ||
               (thirdMax != null && num < secondMax && num > thirdMax)) {
                thirdMax = num;
                continue;
            }
        }
        if(thirdMax != null)    return thirdMax;
        else    return max;
    }
}

// Much Better Solution
public int thirdMax(int[] nums) {
    Integer max1 = null;
    Integer max2 = null;
    Integer max3 = null;
    for (Integer n : nums) {
        if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
        if (max1 == null || n > max1) {
            max3 = max2;
            max2 = max1;
            max1 = n;
        } else if (max2 == null || n > max2) {
            max3 = max2;
            max2 = n;
        } else if (max3 == null || n > max3) {
            max3 = n;
        }
    }
    return max3 == null ? max1 : max3;
}

// Other Better Solution
public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
