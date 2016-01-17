/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head ==null || head.next==null) return head;
        ListNode odd= head;
        ListNode even = odd.next;
        ListNode dummy = new ListNode(0);
        ListNode currEven = dummy;
        while(even!=null && odd!=null){
            currEven.next = even;
            odd.next = even.next;
            odd = even.next;
            if(odd!=null)
                even = odd.next;
            currEven = currEven.next;
            currEven.next = null;
        }
        odd = head;
        while(odd.next!=null)
            odd = odd.next;
        odd.next = dummy.next;
        return head;
    }
}
