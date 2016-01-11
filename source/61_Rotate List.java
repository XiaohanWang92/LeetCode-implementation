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
        if(head==null||head.next==null||k==0) return head;
        ListNode tail = head;
        int len=1;
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }
        int r = k%len;
        if(r == 0)  return head;
        int move = len - r;
        ListNode newTail = head;
        while(move>1){
            newTail = newTail.next;
            move--;
        }
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }
}
