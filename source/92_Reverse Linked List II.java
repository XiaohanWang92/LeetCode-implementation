/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null)   return head;
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i=1;
        while(i<m){
            pre = curr;
            curr = curr.next;
            i++;
        }
        ListNode then = curr.next;
        while(i<n){
            curr.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = curr.next;
            i++;
        }
        return dummy.next;
    }
}
