public class NumArray {
  class SegmentTreeNode{
      int start, end;
      SegmentTreeNode left, right;
      int sum;
      public SegmentTreeNode(int s, int e){
          start=s;
          end=e;
          sum=0;
          left=null;
          right=null;
      }
  }
    SegmentTreeNode root=null;
    public NumArray(int[] nums) {
        root=buildTree(nums, 0, nums.length-1);
    }
    private SegmentTreeNode buildTree(int[] nums, int s, int e){
        if(s>e) return null;
        else{
            SegmentTreeNode grow = new SegmentTreeNode(s,e);
            if(s==e)    grow.sum=nums[s];
            else{
                int middle=s+(e-s)/2;
                grow.left = buildTree(nums, s, middle);
                grow.right = buildTree(nums, middle+1, e);
                grow.sum=grow.left.sum+grow.right.sum;
            }
            return grow;
        }
    }

    void update(int i, int val) {
        updateTree(root,i,val);
    }
    private void updateTree(SegmentTreeNode root, int index, int val){
        if(root.start==root.end)    root.sum=val;
        else{
            int middle=root.start+(root.end-root.start)/2;
            if(index<=middle)   updateTree(root.left, index, val);
            else    updateTree(root.right,index, val);
            root.sum=root.left.sum+root.right.sum;
        }
    }
    public int sumRange(int i, int j) {
        return rangeTree(root, i,j);
    }
    private int rangeTree(SegmentTreeNode root, int sid, int eid){
        if(root.start==sid&&root.end==eid)  return root.sum;
        else{
            int middle=root.start+(root.end-root.start)/2;
            if(eid<=middle) return rangeTree(root.left, sid,eid);
            else if(sid>=middle+1) return rangeTree(root.right,sid,eid);
            else    return rangeTree(root.left,sid,middle)+rangeTree(root.right,middle+1,eid);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
