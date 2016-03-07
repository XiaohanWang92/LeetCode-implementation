/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        int len = 1;
        ListNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
            len++;
        }
        //tmp now is the tail
        k = k % len;
        if(k == 0)  return head;
        int r = len - k;
        while(r > 0){
            ListNode nextOne = head.next;
            head.next = null;
            tmp.next = head;
            tmp = tmp.next;
            head = nextOne;
            r--;
        }
        return head;
    }
}
