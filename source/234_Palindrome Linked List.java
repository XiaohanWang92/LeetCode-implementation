/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        
        ListNode mid=findMid(head);
        mid=mid.next;
        ListNode half=changeDir(mid);
        while(half!=null){
            if(half.val!=head.val){
                return false;
            }
            else{
                head=head.next;
                half=half.next;
            }
        }
        return true;
    }
    private ListNode findMid(ListNode head){
        ListNode speed2 = head.next;
        ListNode speed=head;
        while(speed2!=null&&speed2.next!=null){
            speed=speed.next;
            speed2=speed2.next.next;
        }
        return speed;
    }
    private ListNode changeDir(ListNode head){
        ListNode pre=null;
        while(head!=null){
          ListNode temp=head.next;
          head.next=pre;
          pre=head;
          head=temp;
        }
        return pre;
    }
}