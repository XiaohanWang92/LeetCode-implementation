public class Solution {
    class Pair{
        int val;
        int index;
        public Pair(int val, int index){
            this.val=val;
            this.index=index;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null||nums.length<2)   return res;
        Pair[] pair = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            pair[i] = new Pair(nums[i],i);
        }
        Arrays.sort(pair, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.val-p2.val;
            }
        });
        int i=0, j=nums.length-1;
        while(i<j){
            if((pair[i].val+pair[j].val)==target){
                res[0]=Math.min(pair[i].index,pair[j].index)+1;
                res[1]=Math.max(pair[i].index,pair[j].index)+1;
                return res;
            }else if((pair[i].val+pair[j].val)>target){
                j--;
            }
            else{
                i++;
            }
        }
        return res;
    }
}
