/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode prev = res;
        int carry=0;
        
        while(l1!=null||l2!=null||carry!=0){
            int sum = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) +carry;
            prev.next = new ListNode(sum%10);
            prev = prev.next;
            carry = sum/10;
            if(l1!=null)    l1=l1.next;
            if(l2!=null)    l2=l2.next;
        }
        return res.next;
    }
}
