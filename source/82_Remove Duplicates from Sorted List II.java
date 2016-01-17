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
        if(head==null || head.next==null)   return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(head!=null){
          if(head.next!=null && head.val == head.next.val){
              while(head.next!=null && head.val == head.next.val)
                head = head.next;
              head = head.next;
          }else{
              curr.next = head;
              head = head.next;
              curr = curr.next;
              curr.next = null;
          }
        }
        return dummy.next;
    }
}
