/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)   return head;
        int count = 0;
        ListNode curr = head;
        while(curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if(count == k) {
            curr = reverseKGroup(curr, k);
            while(count > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
                count--;
            }
            head = curr;
        }
        return head;
    }
}
