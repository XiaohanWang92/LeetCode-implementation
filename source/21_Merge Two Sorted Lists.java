/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        if(l1 != null && l2 == null)    return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;

            // l1比l2小或者相等那么都连接l1
            // 反正sorted的，一个一个连接
            // // 相等时两个想一起连接很麻烦的，需要这样
            // {
            //     //先保存“下一个”
            //     ListNode tempNextNode1 = l1.next;
            //     ListNode tempNextNode2 = l2.next;
            //     // 连接
            //     curr.next = l1;
            //     curr = curr.next;
            //     curr.next = l2;
            //     curr = curr.next;
            //     // l1和l2指向“下一个”
            //     l1 = tempNextNode1;
            //     l2 = tempNextNode2;
            // }
            // // 如果test case是：l1：[1 -> 1 -> 1], l2: [1 -> 1], 难道还想5个相等的一起连么OuO
            } else {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
        }

        // 这里也和你不一样，因为剩下的尾巴是sorted的，直接连接一下就好，没必要一个一个连接了
        if(l1 != null)  curr.next = l1;
        if(l2 != null)  curr.next = l2;
        return dummy.next;
    }
}
