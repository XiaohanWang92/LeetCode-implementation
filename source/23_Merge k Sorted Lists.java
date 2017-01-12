/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)    return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new ListNodeComparator());
        for(ListNode node : lists) {
            if(node != null)
                pq.offer(node);
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(!pq.isEmpty()) {
            ListNode currMinimum = pq.poll();
            curr.next = currMinimum;
            curr = curr.next;
            if(currMinimum.next != null)
                pq.offer(currMinimum.next);
        }
        return head.next;
    }
}
