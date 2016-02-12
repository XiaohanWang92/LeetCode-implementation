/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    class myCom implements Comparator<ListNode>{
        @Override
        public int compare(ListNode l1, ListNode l2){
            return l1.val - l2.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)    return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new myCom());
        
        for(ListNode node : lists){
            if(node!=null)
                pq.offer(node);
        }
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        while(!pq.isEmpty()){
            ListNode currMin = pq.poll();
            curr.next = currMin;
            curr = curr.next;
            if(currMin.next!=null)
                pq.offer(currMin.next);
        }
        
        return head.next;
    }
}
