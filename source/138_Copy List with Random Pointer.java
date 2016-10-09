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
        Map<RandomListNode, RandomListNode> copyMap = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null) {
            copyMap.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            RandomListNode copyRandom = cur.random;
            copyMap.get(cur).random = copyMap.get(copyRandom);
            RandomListNode copyNext = cur.next;
            copyMap.get(cur).next = copyMap.get(copyNext);
            cur = cur.next;
        }
        return copyMap.get(head);
    }
}
