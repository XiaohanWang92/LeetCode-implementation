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
        if((p == null && q != null) || (p != null && q == null))
            return false;
        if(p == null && q == null)
            return true;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (p != null && q == null))
            return false;
        if(p == null && q == null)
            return true;
        if(p.val != q.val)
            return false;
        Deque<TreeNode> pQueue = new LinkedList<>();
        Deque<TreeNode> qQueue = new LinkedList<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while(pQueue.size() != 0 || qQueue.size() != 0) {
            if(pQueue.size() != qQueue.size())
                return false;
            int size = pQueue.size();
            for(int i = 1; i <= size; i++) {
                TreeNode pNode = pQueue.poll();
                TreeNode qNode = qQueue.poll();
                if(pNode.val != qNode.val)
                    return false;
                if((pNode.left != null && qNode.left == null) || (pNode.left == null && qNode.left != null))
                    return false;
                if((pNode.right != null && qNode.right == null) || (pNode.right == null && qNode.right != null))
                    return false;
                if(pNode.left != null)
                    pQueue.offer(pNode.left);
                if(pNode.right != null)
                    pQueue.offer(pNode.right);
                if(qNode.left != null)
                    qQueue.offer(qNode.left);
                if(qNode.right != null)
                    qQueue.offer(qNode.right);
            }
        }
        if(!pQueue.isEmpty() || !qQueue.isEmpty())
            return false;
        return true;
    }
}

/*
Other Iterative method
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
