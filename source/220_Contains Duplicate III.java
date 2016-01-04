public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||t<0) return false;
        Map<Integer,Integer> hs = new HashMap<>();
        int bucket = t+1;
        for(int i=0;i<nums.length;i++){
            if(i>k) hs.remove(getBucket(nums[i-k-1], bucket));
            int bucketID = getBucket(nums[i], bucket);
            if(hs.containsKey(bucketID))    return true;
            if(hs.containsKey(bucketID-1)&&Math.abs(nums[i] - hs.get(bucketID-1))<bucket)    return true;
            if(hs.containsKey(bucketID+1)&&Math.abs(nums[i] - hs.get(bucketID+1))<bucket)    return true;
            hs.put(bucketID, nums[i]);//if not contains such key as bucket
        }
        return false;
    }
    public int getBucket(int num, int bucket){
        return num<0?(num+1)/bucket-1:num/bucket;
    }
}
