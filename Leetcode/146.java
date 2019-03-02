class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}
class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head;
    Node tail;
    int size=0;
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        this.capacity=capacity;
        size=0;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }
    public void insertAtFront(Node node){
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    public void deleteFromQueue(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public int get(int key) {
        if(map.get(key)!=null){
            int val = map.get(key).val;
            deleteFromQueue(map.get(key));
            Node node = new Node(key,val);
            insertAtFront(node);
            map.put(key,node);
            return val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.get(key)!=null){
            deleteFromQueue(map.get(key));
            Node node = new Node(key,value);
            insertAtFront(node);
            map.put(key,node);
        }else{
            Node node = new Node(key,value);
            if(size<capacity){
                insertAtFront(node);
                size+=1;
            }else{
                insertAtFront(node);
                map.remove(tail.prev.key);
                deleteFromQueue(tail.prev);
            }
            map.put(key,node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
