public class LRUCache {
    class DLLNode {
        int value;
        int key;
        DLLNode pre;
        DLLNode next;
        public DLLNode(int v, int k){
            value = v;
            //key is for evicting, use key to find element in HashMap
            key = k;
        }
        public DLLNode(){
            //do nothing, for dummy head and end
            //don't forget to instantiate them!
        }
    }
    
    private DLLNode head;
    private DLLNode end;
    
    private void addNode(DLLNode node){
        node.pre = head;
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
    }
    
    private void remove(DLLNode node){
        //reference gone, automatically waiting for gabage collector 
        DLLNode preNode = node.pre;
        DLLNode nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }
    
    private void newlyUsed(DLLNode node){
        remove(node);
        addNode(node);
    }
    
    private DLLNode evictLeastUsed(){
        DLLNode leastUsed = end.pre;
        remove(leastUsed);
        return leastUsed;
    }
    
    private int capacity;
    private int current;
    private Map<Integer, DLLNode> map;
    
    public LRUCache(int capacity) {
        current = 0;
        this.capacity = capacity;
        head = new DLLNode();
        end = new DLLNode();
        head.next = end;
        end.pre = head;
        map = new HashMap<Integer, DLLNode>();
    }
    
    public int get(int key) {
        DLLNode res = map.get(key);
        if(res == null)
            return -1;
        //update newly used cache
        newlyUsed(res);
        return res.value;
    }
    
    public void set(int key, int value) {
        DLLNode res = map.get(key);
        if(res!=null){
            res.value = value;
            newlyUsed(res);
        }else{
            DLLNode newOne = new DLLNode(value, key);
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
