/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)   return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr = head;
        ListNode pre1 = dummy1;
        ListNode pre2 = dummy2;
        while(curr!=null){
            if(curr.val<x){
                ListNode tmp = curr.next;
                pre1.next = curr;
                curr.next = null;
                curr = tmp;
                pre1 = pre1.next;
            }else{
                ListNode tmp = curr.next;
                pre2.next = curr;
                curr.next = null;
                curr = tmp;
                pre2 = pre2.next;
            }
        }
        ListNode newHead = new ListNode(0);
        if(dummy1.next!=null)
            newHead.next = dummy1.next;
        if(dummy2.next!=null)
            if(dummy1.next==null)
                newHead.next = dummy2.next;
            else
                pre1.next = dummy2.next;
        return newHead.next;
    }
}
