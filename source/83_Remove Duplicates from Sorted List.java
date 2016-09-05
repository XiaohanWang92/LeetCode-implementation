/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Bad method
// public class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if(head==null||head.next==null) return head;
//         ListNode curr = head;
//         ListNode pre =curr;
//         Set<Integer> hs = new HashSet<Integer>();
//         while(curr!=null){
//             if(!hs.contains(curr.val)){
//                 hs.add(curr.val);
//                 pre=curr;
//                 curr=curr.next;
//             }
//             else{
//                 curr=curr.next;
//                 pre.next=curr;//pre needs to be instantiated first!
//             }
//         }
//         return head;
//     }
// }
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
        // Consider extreme condition, head.val = Integer.MIN_VAL
        ListNode dummyHead = new ListNode(head.val - 1);
        ListNode currentPosition = dummyHead;
        while(head != null) {
            if(currentPosition.val == head.val)
                head = head.next;
            else {
                currentPosition.next = head;
                head = head.next;
                currentPosition = currentPosition.next;
                currentPosition.next = null;
            }
        }
        return dummyHead.next;
    }
}
