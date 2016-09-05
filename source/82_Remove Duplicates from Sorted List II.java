/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        // Makes sure that dummy's value is different from any list element
        ListNode dummyHead = new ListNode(-1);
        ListNode currentNodePosition = dummyHead;
        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val)
                    head = head.next;
                head = head.next;
            } else {
                currentNodePosition.next = head;

                // Must update at once to avoid null setting side effect
                head = head.next;
                currentNodePosition = currentNodePosition.next;

                // Avoid trailing duplication such as 1->2->2
                currentNodePosition.next = null;
            }
        }
        return dummyHead.next;
    }
}
