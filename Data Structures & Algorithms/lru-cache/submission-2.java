class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int value;
        Node(int k,int v){
            this.prev = null;
            this.next = null;
            this.key = k;
            this.value = v;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap = 0;
    HashMap<Integer,Node> map; 

    public void addNode(Node newNode){
        Node oldNode = head.next;
        head.next = newNode;
        oldNode.prev = newNode;
        newNode.next = oldNode;
        newNode.prev = head;
    }

    public void removeNode(Node newNode) {
        Node prev = newNode.prev;
        Node next = newNode.next;

        prev.next = next;
        next.prev = prev;
        // newNode.prev = null;
        // newNode.next = null;
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap();
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }else{
            Node item = map.get(key);

            map.remove(key);
            removeNode(item);

            
            addNode(item);
            map.put(key,item);
            return item.value;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node newNode = map.get(key);
            removeNode(newNode);
            map.remove(key);
        }
        if(map.size() == this.cap){
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }
        Node newNodeToAdd = new Node(key,value);
        addNode(newNodeToAdd);
        map.put(key,newNodeToAdd);
    }
}
