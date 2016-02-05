/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
                if (fast == slow){
                    ListNode meet = head; 
                    while (meet != slow){
                        slow = slow.next;
                        meet = meet.next;
                    }
                return slow;
                }
            }
        return null;
    }
}
