public class LFUCache {
    private int capacity;
    private Map<Integer, Integer> valueMap;
    private Map<Integer, FreqNode> freqMap;
    private FreqNode head;
    private FreqNode tail;
    
    class FreqNode {
        int freq;

        // maintain adding order so last recently key will be on head
        LinkedHashSet<Integer> keys;
        FreqNode prev;
        FreqNode next;

        public FreqNode(int frequency) {
            freq = frequency;
            keys = new LinkedHashSet<>();
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>();
        freqMap = new HashMap<>();
        head = new FreqNode(0);
        tail = new FreqNode(0);
        connectTwoNodes(head, tail);
    }
    
    public int get(int key) {
        if(valueMap.containsKey(key)) {
            updateFrequency(key);
            return valueMap.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(capacity == 0)   return;
        if(valueMap.containsKey(key)) {
            valueMap.put(key, value);
            updateFrequency(key);
        } else {

            // remove last frequent first before adding new one
            if(valueMap.size() >= capacity) {
                removeLastFrequent();
            }
            FreqNode node = tail.prev;
            if(node.freq == 1) {
                node.keys.add(key);
                freqMap.put(key, node);
            } else {
                FreqNode newNode = new FreqNode(1);
                freqMap.put(key, newNode);
                newNode.keys.add(key);
                node.next = newNode;
                newNode.prev = node;
                newNode.next = tail;
                tail.prev = newNode;
            }
            valueMap.put(key, value);
        }
    }
    
    private void connectTwoNodes(FreqNode front, FreqNode back) {
        front.next = back;
        back.prev = front;
    }
    
    private void updateFrequency(int key) {
        FreqNode node = freqMap.get(key);
        node.keys.remove(key);
        int newFreq = node.freq + 1;

        // key's frequent is the only one or only largest
        if(node.prev == head || node.prev.freq > newFreq) {
            FreqNode newNode = new FreqNode(newFreq);
            newNode.keys.add(key);
            FreqNode prevNode = node.prev;
            connectTwoNodes(prevNode, newNode);
            connectTwoNodes(newNode, node);
            freqMap.put(key, newNode);
        } else {
            node.prev.keys.add(key);

            // also need to update the node for the key
            freqMap.put(key, node.prev);
        }
        if(node.keys.size() == 0) {

            // only need to update references within this node
            // updating freqMap will make node de-referred automatically
            removeNode(node);
        }
    }
    
    private void removeNode(FreqNode node) {
        FreqNode prev = node.prev;
        FreqNode next = node. next;
        connectTwoNodes(prev, next);
        node.prev = null;
        node.next = null;
    }
    
    private void removeLastFrequent() {
        if(tail.prev == head)   return;
        FreqNode node = tail.prev;
        int key = 0;

        // first is the last recent key
        for(int n : node.keys) {
            key = n;
            break;
        }
        node.keys.remove(key);
        valueMap.remove(key);
        freqMap.remove(key);
        if(node.keys.size() == 0) {
            removeNode(node);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */
