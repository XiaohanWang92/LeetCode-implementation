/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode current = head;
        ListNode previous = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}

//recursive method
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode rest = head.next;
        ListNode newHead = reverse(rest);
        rest.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode reverse(ListNode head) {
        if(head.next == null)
            return head;
        ListNode rest = head.next;
        ListNode newHead = reverse(rest);
        rest.next = head;
        head.next = null;
        return newHead;
    }
}
