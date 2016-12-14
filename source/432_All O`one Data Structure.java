public class AllOne {

    class CountNode {
        int count;
        Set<String> keySet;
        CountNode previous;
        CountNode next;
        public CountNode(int count) {
            this.count = count;
            keySet = new HashSet<>();
        }
        
        public void add(String key) {
            keySet.add(key);
        }
        
        public void remove(String key) {
            keySet.remove(key);
        }
    }
    
    private Map<String, Integer> keyCntMap;
    private Map<Integer, CountNode> cntNodeMap;
    private CountNode head;
    private CountNode tail;
    
    /** Initialize your data structure here. */
    public AllOne() {
        keyCntMap = new HashMap<>();
        cntNodeMap = new HashMap<>();
        head = new CountNode(-1);
        tail = new CountNode(-1);
        head.next = tail;
        tail.previous = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {

        // if key exists
        if(keyCntMap.containsKey(key)) {
            int count = keyCntMap.get(key) + 1;
            keyCntMap.put(key, count);
            CountNode oldNode = cntNodeMap.get(count - 1);

            // if current count bucket exists, just update
            if(cntNodeMap.containsKey(count)) {
                cntNodeMap.get(count).add(key);
                oldNode.remove(key);

            // if not, instantiate a new bucket and update
            } else {
                CountNode newNode = new CountNode(count);
                newNode.add(key);
                cntNodeMap.put(count, newNode);
                oldNode.remove(key);
                CountNode preNode = oldNode.previous;
                addNewNode(preNode, newNode, oldNode);
            }

            // if old bucket is empty, remove it
            if(oldNode.keySet.size() == 0) {
                removeNode(oldNode);
                cntNodeMap.remove(oldNode.count);
            }

        // if key does not exist
        } else {
            keyCntMap.put(key, 1);

            // same logic based on if bucket of count 1 exists or not
            if(cntNodeMap.containsKey(1)) {
                cntNodeMap.get(1).add(key);
            } else {
                CountNode newNode = new CountNode(1);
                newNode.add(key);
                cntNodeMap.put(1, newNode);
                CountNode preNode = tail.previous;
                addNewNode(preNode, newNode, tail);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

        // dec method changes data structure iff key exists
        if(keyCntMap.containsKey(key)) {
            int count = keyCntMap.get(key) - 1;
            CountNode oldNode = cntNodeMap.get(count + 1);
            if(count == 0) {
                keyCntMap.remove(key);
                oldNode.remove(key);

            // the same logic
            } else {
                keyCntMap.put(key, count);
                oldNode.remove(key);
                if(cntNodeMap.containsKey(count)) {
                    cntNodeMap.get(count).add(key);
                } else {
                    CountNode newNode = new CountNode(count);
                    newNode.add(key);
                    cntNodeMap.put(count, newNode);
                    CountNode preNode = oldNode.previous;
                    addNewNode(preNode, newNode, oldNode);
                }
            }
            if(oldNode.keySet.size() == 0) {
                removeNode(oldNode);
                cntNodeMap.remove(oldNode.count);
            }
        }

    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(head.next == tail)   return "";
        return head.next.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.next == tail)   return "";
        return tail.previous.keySet.iterator().next();
    }
    
    private void removeNode(CountNode node) {
        CountNode pre = node.previous;
        CountNode next = node.next;
        pre.next = next;
        next.previous = pre;
        node.previous = null;
        node.next = null;
    }
    
    private void addNewNode(CountNode preNode, CountNode newNode, CountNode nextNode) {
        preNode.next = newNode;
        newNode.previous = preNode;
        newNode.next = nextNode;
        nextNode.previous = newNode;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
