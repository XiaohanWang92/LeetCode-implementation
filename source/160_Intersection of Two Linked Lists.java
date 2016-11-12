/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /*for two lists with length n and n + k, if they collide at mth node, (m <= n), then it is assertive that
 we can begin checking collision at (k + 1)th node for list n + k, 1st node for list n, 
 align them to same length and forward and check them only by one together*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)  return null;
        int lenA = 0, lenB = 0;
        ListNode tmpA = headA, tmpB = headB;
        while(tmpA != null) {
            tmpA = tmpA.next;
            lenA++;
        }
        while(tmpB != null) {
            tmpB = tmpB.next;
            lenB++;
        }
        tmpA = headA;
        tmpB = headB;
        int pass = Math.abs(lenA - lenB);
        if(lenA > lenB) {
            while(pass != 0) {
                tmpA = tmpA.next;
                pass--;
            }
        } else {
            while(pass != 0) {
                tmpB = tmpB.next;
                pass--;
            }
        }
        while(tmpB != null) {
            if(tmpB == tmpA)
                return tmpB;
            tmpB = tmpB.next;
            tmpA = tmpA.next;
        }
        return null;
    }
}
