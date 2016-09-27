/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)    return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode current = head;
        while(current != null) {
            map.put(current, new RandomListNode(current.label));
            current = current.next;
        }
        current = head;
        while(current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}
