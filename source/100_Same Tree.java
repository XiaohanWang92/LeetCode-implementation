/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)    return true;
        if((p!=null&&q==null)||(p==null&&q!=null))  return false;
        if(p.val!=q.val)    return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
/*
Iterative method
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pList = new LinkedList<>();
        Queue<TreeNode> qList = new LinkedList<>();
        
        pList.offer(p);
        qList.offer(q);
        
        while(pList.size()!=0 && qList.size()!=0){
            
            TreeNode pTem = pList.poll();
            TreeNode qTem = qList.poll();
            
            if(pTem == null){
                if(qTem == null){
                    continue;
                }else{
                    return false;
                }
            }
            
            if(qTem == null || qTem.val != pTem.val)
                return false;
            
            pList.offer(pTem.left);
            pList.offer(pTem.right);
            qList.offer(qTem.left);
            qList.offer(qTem.right);
        }
        
        return pList.size() == qList.size();
        
    }
}
*/
