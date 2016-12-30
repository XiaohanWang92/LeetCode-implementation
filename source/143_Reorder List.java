/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)   return;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l2 = reverse(slow);
        ListNode l1 = head;
        merge(l1,l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while(l1 != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            if(tmp1 == null)  return;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
    }
}
