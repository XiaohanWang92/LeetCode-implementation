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
 /*for two lists with length n and n+k, if they collide at mth node, (m<=n), then it is assertive that
 we can begin checking collision at (k+1)th node for list n+k, 1st node for list n, 
 align them to same length and forward and check them only by one together*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)    return null;
        int lenA=0;
        int lenB=0;
        ListNode check=headA;
        while(check!=null){
            check=check.next;
            lenA++;
        }
        check=headB;
        while(check!=null){
            check=check.next;
            lenB++;
        }
        int pass;
        ListNode refA=headA;
        ListNode refB=headB;
        if(lenA>lenB){
            pass=lenA-lenB;
            while(pass!=0){
                refA=refA.next;
                pass--;
            }
        }
        else{
            pass=lenB-lenA;
            while(pass!=0){
                refB=refB.next;
                pass--;
            }
        }
        while(refA!=null){
            if(refA==refB)  return refA;//not value equal but reference equal!
            refA=refA.next;
            refB=refB.next;
        }
        return null;
    }
}
