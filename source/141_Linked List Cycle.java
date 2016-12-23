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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode onePace = head;
        ListNode twoPace = head;
        while(twoPace != null && twoPace.next != null) {
            onePace = onePace.next;
            twoPace = twoPace.next.next;
            if(onePace == twoPace)
                return true;
        }
        return false;
    }
}
