/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)   return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;//head will be swapped
        ListNode curr = dummy;
        while(curr.next!=null && curr.next.next!=null){
            ListNode left = curr.next;
            ListNode right = curr.next.next;
            ListNode nextOne = right.next;
            left.next = nextOne;
            right.next = left;
            curr.next = right;
            curr = left;
        }
        return dummy.next;
    }
}
