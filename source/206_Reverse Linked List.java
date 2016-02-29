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
        if(head==null||head.next==null) return head;
        ListNode curr=head;
        ListNode pre=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
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
    private ListNode reverse(ListNode head){
        if(head.next == null)
            return head;
        ListNode rest = head.next;
        ListNode newHead = reverse(rest);
        rest.next = head;
        head.next = null;
        return newHead;
    }
}
