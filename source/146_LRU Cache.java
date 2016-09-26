public class LRUCache {

    class DoubleLinkedListNode {
        int value;
        int key;
        DoubleLinkedListNode previous;
        DoubleLinkedListNode next;

        public DoubleLinkedListNode(int v, int k){
            value = v;

            //  key is to find element in HashMap with evicting
            key = k;
        }

        public DoubleLinkedListNode(){

            // Empty method
            // Do nothing, for dummy head and end
            // Don't forget to instantiate them!
        }
    }
    
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    
    private void addNode(DoubleLinkedListNode node){
        node.previous = head;
        head.next.previous = node;
        node.next = head.next;
        head.next = node;
    }
    
    private void remove(DoubleLinkedListNode node){

        // Reference gone, automatically waiting for gabage collector 
        DoubleLinkedListNode previousNode = node.previous;
        DoubleLinkedListNode nextNode = node.next;
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
    }
    
    private void newlyUsed(DoubleLinkedListNode node){
        remove(node);
        addNode(node);
    }
    
    private DoubleLinkedListNode evictLeastUsed(){
        DoubleLinkedListNode leastUsed = end.previous;
        remove(leastUsed);
        return leastUsed;
    }
    
    private int capacity;
    private int current;
    private Map<Integer, DoubleLinkedListNode> map;
    
    public LRUCache(int capacity) {
        current = 0;
        this.capacity = capacity;
        head = new DoubleLinkedListNode();
        end = new DoubleLinkedListNode();
        head.next = end;
        end.previous = head;
        map = new HashMap<Integer, DoubleLinkedListNode>();
    }
    
    public int get(int key) {
        DoubleLinkedListNode result = map.get(key);
        if(result == null)
            return -1;

        // Update newly used cache
        newlyUsed(result);
        return result.value;
    }
    
    public void set(int key, int value) {
        DoubleLinkedListNode result = map.get(key);
        if(result != null) {
            result.value = value;
            newlyUsed(result);
        } else {
            DoubleLinkedListNode newOne = new DoubleLinkedListNode(value, key);
            map.put(key, newOne);
            addNode(newOne);
            current++;
            if(current > capacity){
                map.remove(evictLeastUsed().key);
                current--;
            }
        }
    }
}
