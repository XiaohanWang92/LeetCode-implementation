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
        if(head == null || head.next == null)
            return head;
        ListNode dummyHead1 = new ListNode(0);
        ListNode smallerTail = dummyHead1;
        ListNode dummyHead2 = new ListNode(0);
        ListNode biggerTail = dummyHead2;
        ListNode currentNode = head;
        while(currentNode != null) {
            if(currentNode.val < x) {
                smallerTail.next = currentNode;
                smallerTail = smallerTail.next;
                ListNode temp = currentNode;
                currentNode = currentNode.next;
                temp.next = null;
            } else {
                biggerTail.next = currentNode;
                biggerTail = biggerTail.next;
                ListNode temp = currentNode;
                currentNode = currentNode.next;
                temp.next = null;
            }
        }
        smallerTail.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
